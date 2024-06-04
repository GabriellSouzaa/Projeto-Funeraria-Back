package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.usecases.SellerSallesGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Seller Salles")
@RestController
@RequestMapping("/seller-salles")
public class SellerSallesController {

    private final SellerSallesGateway sellerSallesGateway;

    public SellerSallesController(SellerSallesGateway sellerSallesGateway){
        this.sellerSallesGateway = sellerSallesGateway;
    }

    @GetMapping(path = "/report")
    ResponseEntity<?> getReportSallesSeller(){
        return this.sellerSallesGateway.getReportSales();
    }
}
