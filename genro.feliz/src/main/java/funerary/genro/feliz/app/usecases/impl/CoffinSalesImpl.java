package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.requests.CoffinSalesRequest;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.app.models.responses.CoffinSalesResponse;
import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.repositories.CoffinRepository;
import funerary.genro.feliz.app.repositories.CoffinSalesRepository;
import funerary.genro.feliz.app.usecases.CoffinSalesGateway;
import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.CoffinSales;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CoffinSalesImpl implements CoffinSalesGateway {


    private final CoffinSalesRepository coffinSalesRepository;

    public CoffinSalesImpl(CoffinSalesRepository coffinSalesRepository){
        this.coffinSalesRepository = coffinSalesRepository;
    }

    @Override
    public List<CoffinSalesResponse> getCoffinsSales() {
        List<CoffinSales> coffinSales = this.coffinSalesRepository.findAll();
        return coffinSales.stream().map(CoffinSalesResponse::from).collect(Collectors.toList());
    }

    @Override
    public CoffinSalesResponse getCoffinSales(Long id) {
        Optional<CoffinSales> optionalCoffinSales = this.coffinSalesRepository.findById(id);
        CoffinSales coffinSales;
        if (optionalCoffinSales.isEmpty()) {
            throw new ClientNotFoundException("Venda de Caixão não Encontrado!");
        } else {
            coffinSales = optionalCoffinSales.get();
        }

        return CoffinSalesResponse.from(coffinSales);
    }


    @Override
    public void createCoffinSales(CoffinSalesRequest coffinSalesRequest) {
        CoffinSales newCoffinSales = new CoffinSales();
        newCoffinSales.setCoffin(coffinSalesRequest.getCoffin());
        newCoffinSales.setSeller(coffinSalesRequest.getSeller());
        newCoffinSales.setDataVenda(coffinSalesRequest.getDataVenda());
        this.coffinSalesRepository.save(newCoffinSales);
    }

    @Override
    public void updateCoffinSales(Long id, CoffinSalesRequest coffinSalesRequest) {
        Optional<CoffinSales> optionalCoffinSales = this.coffinSalesRepository.findById(id);

        if (optionalCoffinSales.isEmpty()) {
            throw new ClientNotFoundException("Venda de Caixão não Encontrada!");
        } else {
            CoffinSales coffinSales = optionalCoffinSales.get();
            coffinSales.setCoffin(coffinSalesRequest.getCoffin());
            coffinSales.setSeller(coffinSalesRequest.getSeller());
            coffinSales.setDataVenda(coffinSalesRequest.getDataVenda());
            this.coffinSalesRepository.save(coffinSales);
        }
    }
    public List<CoffinSalesResponse> coffins(){
        List<CoffinSalesResponse> coffinsSales = this.getCoffinsSales();
        LocalDate now = LocalDate.now();
        LocalDate startOfCurrentMonth = now.withDayOfMonth(1);

       return coffinsSales.stream()
                .filter(sale -> sale.getDataVenda().isAfter(startOfCurrentMonth)
                        && sale.getDataVenda().isBefore(now.plusMonths(1)))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<byte[]> getReportToCoffinSales() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("relatorios/venda-mensal-caixao.jrxml")).getFile());


        List<CoffinSalesResponse> coffinsSales = this.coffins();


        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource coffin = new JRBeanCollectionDataSource(coffinsSales);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("coffinsSales", coffin);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);


        byte[] bytes = ReportUtilsImpl.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return ReportUtilsImpl.retornaResponseEntityRelatorio(bytes);
    }

    @Override
    public void deleteCoffinSales(Long id) {
        Optional<CoffinSales> optionalCoffinSales = this.coffinSalesRepository.findById(id);
        if (optionalCoffinSales.isEmpty()) {
            throw new ClientNotFoundException("Venda de Caixão não Encontrado!");
        } else {
            this.coffinSalesRepository.deleteById(id);
        }
    }
}
