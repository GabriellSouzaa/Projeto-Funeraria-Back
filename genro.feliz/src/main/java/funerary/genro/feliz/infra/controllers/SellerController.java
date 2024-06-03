package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.requests.SellerRequest;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.app.models.responses.SellerResponse;
import funerary.genro.feliz.app.usecases.SellerGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Seller")
@RestController
@RequestMapping("/seller")
public class SellerController {

    private final SellerGateway sellerGateway;

    public SellerController(SellerGateway sellerGateway){
        this.sellerGateway = sellerGateway;
    }

    @GetMapping
    ResponseEntity<?> getSeller(){
        List<SellerResponse> responses = this.sellerGateway.getSellers();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getSeller(@PathVariable Long id) {
        SellerResponse response = this.sellerGateway.getSeller(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/create")
    ResponseEntity<?> createSeller(@RequestBody SellerRequest sellerRequest){
        this.sellerGateway.createSeller(sellerRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/update/{id}")
    ResponseEntity<?> updateSeller(@PathVariable Long id, @RequestBody SellerRequest sellerRequest){
        this.sellerGateway.updateSeller(id, sellerRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteSeller(@PathVariable Long id){
        this.sellerGateway.deleteSeller(id);
        return ResponseEntity.ok().build();
    }

}
