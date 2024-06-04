package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.models.responses.FuneralParlorUsagesResponse;
import funerary.genro.feliz.app.models.responses.SellerSallesResponse;
import funerary.genro.feliz.app.repositories.FuneralParlorUsagesRepository;
import funerary.genro.feliz.app.usecases.FuneralParlorGateway;
import funerary.genro.feliz.app.usecases.FuneralParlorUsagesGateway;
import funerary.genro.feliz.domain.FuneralParlorUsages;
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
public class FuneralParlorUsagesImpl implements FuneralParlorUsagesGateway {

    private final FuneralParlorUsagesRepository funeralParlorUsagesRepository;

    public FuneralParlorUsagesImpl(FuneralParlorUsagesRepository funeralParlorUsagesRepository){
        this.funeralParlorUsagesRepository = funeralParlorUsagesRepository;
    }

    @Override
    public List<FuneralParlorUsagesResponse> getFuneralParlorsUsages() {
        List<FuneralParlorUsages> funeralParlorUsages = this.funeralParlorUsagesRepository.findAll();
        return funeralParlorUsages.stream().map(FuneralParlorUsagesResponse::from).collect(Collectors.toList());
    }


    public List<FuneralParlorUsagesResponse> sellerSalles(){
        List<FuneralParlorUsagesResponse> funeralParlorUsagesResponses = this.getFuneralParlorsUsages();

        LocalDate now = LocalDate.now();
        LocalDate startOfCurrentMonth = now.withDayOfMonth(1);
        LocalDate startOfNextMonth = startOfCurrentMonth.plusMonths(1);

        return funeralParlorUsagesResponses.stream()
                .filter(sale -> !sale.getDataUso().isBefore(startOfCurrentMonth)
                        && sale.getDataUso().isBefore(startOfNextMonth))
                .collect(Collectors.toList());
    }


    @Override
    public ResponseEntity<byte[]> getReportFuneralParlosUsages() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("relatorios/salas-usadas.jrxml")).getFile());

        List<FuneralParlorUsagesResponse> funeralParlorUsagesResponses = this.sellerSalles();


        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource funeralParlor = new JRBeanCollectionDataSource(funeralParlorUsagesResponses);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("funeralParlorUsages", funeralParlor);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);


        byte[] bytes = ReportUtilsImpl.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return ReportUtilsImpl.retornaResponseEntityRelatorio(bytes);
    }


}
