package funerary.genro.feliz.infra.controllers;


import funerary.genro.feliz.app.models.requests.BeneficiaryRequest;
import funerary.genro.feliz.app.models.responses.BeneficiaryResponse;
import funerary.genro.feliz.app.usecases.BeneficiaryGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Beneficiary")
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    private final BeneficiaryGateway beneficiaryGateway;


    public BeneficiaryController(BeneficiaryGateway beneficiaryGateway){
        this.beneficiaryGateway = beneficiaryGateway;
    }


    @GetMapping
    ResponseEntity<?> getFindBeneficiary(){
        List<BeneficiaryResponse> responses = this.beneficiaryGateway.getBeneficiarys();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getBeneficiary(@PathVariable Long id) {
        BeneficiaryResponse response = this.beneficiaryGateway.getBeneficiary(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/create")
    ResponseEntity<?> createBeneficiary(@RequestBody BeneficiaryRequest beneficiaryRequest){
        this.beneficiaryGateway.createBeneficiary(beneficiaryRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/update/{id}")
    ResponseEntity<?> updateBeneficiary(@PathVariable Long id, @RequestBody BeneficiaryRequest beneficiaryRequest){
        this.beneficiaryGateway.updateBeneficiary(id, beneficiaryRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteBeneficiary(@PathVariable Long id){
        this.beneficiaryGateway.deleteBeneficiary(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/client/{id}")
    ResponseEntity<?> getBeneficiariesOfClient(@PathVariable Long id){
        this.beneficiaryGateway.getBeneficiariesOfClient(id);
        return ResponseEntity.ok().build();
    }
}
