package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.app.usecases.CoffinGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Coffin")
@RequestMapping("/coffin")
public class CoffinController {

    private final CoffinGateway coffinGateway;


    public CoffinController(CoffinGateway coffinGateway){
        this.coffinGateway = coffinGateway;
    }


    @GetMapping
    ResponseEntity<?> getFindCoffins(){
        List<CoffinResponse> responses = this.coffinGateway.getCoffins();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getCoffin(@PathVariable Long id) {
        CoffinResponse response = this.coffinGateway.getCoffin(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/create")
    ResponseEntity<?> createCoffin(@RequestBody CoffinRequest coffinRequest){
        this.coffinGateway.createCoffin(coffinRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/update/{id}")
    ResponseEntity<?> updateCoffin(@PathVariable Long id, @RequestBody CoffinRequest coffinRequest){
        this.coffinGateway.updateCoffin(id, coffinRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteCoffin(@PathVariable Long id){
        this.coffinGateway.deleteCoffin(id);
        return ResponseEntity.ok().build();
    }
}
