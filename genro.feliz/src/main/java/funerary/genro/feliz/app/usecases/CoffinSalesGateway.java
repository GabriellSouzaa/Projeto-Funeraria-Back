package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.requests.CoffinSalesRequest;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.app.models.responses.CoffinSalesResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoffinSalesGateway {

    List<CoffinSalesResponse> getCoffinsSales();

    CoffinSalesResponse getCoffinSales(Long id);

    void createCoffinSales(CoffinSalesRequest coffinSalesRequest);


    void updateCoffinSales(Long id, CoffinSalesRequest coffinSalesRequest);

    ResponseEntity<byte[]> getReportToCoffinSales();

    void deleteCoffinSales(Long id);
}
