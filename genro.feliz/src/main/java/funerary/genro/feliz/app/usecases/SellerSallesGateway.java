package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.responses.SellerResponse;
import funerary.genro.feliz.app.models.responses.SellerSallesResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SellerSallesGateway {

    List<SellerSallesResponse> getSellersSalles();

    ResponseEntity<byte[]> getReportSales();
}
