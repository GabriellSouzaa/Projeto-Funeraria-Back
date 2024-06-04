package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.models.responses.SellerResponse;
import funerary.genro.feliz.app.models.responses.SellerSallesResponse;
import funerary.genro.feliz.app.repositories.SellerSallesRepository;
import funerary.genro.feliz.app.usecases.SellerSallesGateway;
import funerary.genro.feliz.domain.SellerSalles;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SellerSallesImpl implements SellerSallesGateway {

    private final SellerSallesRepository sellerSallesRepository;

    public SellerSallesImpl(SellerSallesRepository sellerSallesRepository){
        this.sellerSallesRepository = sellerSallesRepository;
    }

    @Override
    public List<SellerSallesResponse> getSellersSalles() {
        List<SellerSalles> sellerSalles = this.sellerSallesRepository.findAll();
        return sellerSalles.stream().map(SellerSallesResponse::from).collect(Collectors.toList());
    }

    public List<SellerSallesResponse> sellerSalles(){
        List<SellerSallesResponse> sellerSalles = this.getSellersSalles();

        LocalDate now = LocalDate.now();
        LocalDate startOfCurrentMonth = now.withDayOfMonth(1);
        LocalDate startOfNextMonth = startOfCurrentMonth.plusMonths(1);

        return sellerSalles.stream()
                .filter(sale -> !sale.getDataVenda().isBefore(startOfCurrentMonth)
                        && sale.getDataVenda().isBefore(startOfNextMonth))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<byte[]> getReportSales() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("relatorios/venda-mensal-vendedor.jrxml")).getFile());


        List<SellerSallesResponse> sallesResponses = this.sellerSalles();


        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource salles = new JRBeanCollectionDataSource(sallesResponses);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("sellerSalles", salles);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);


        byte[] bytes = ReportUtilsImpl.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return ReportUtilsImpl.retornaResponseEntityRelatorio(bytes);
    }
}
