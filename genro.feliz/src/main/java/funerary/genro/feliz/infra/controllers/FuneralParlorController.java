package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.requests.FuneralParlorRequest;
import funerary.genro.feliz.app.models.responses.FuneralParlorResponse;
import funerary.genro.feliz.app.usecases.FuneralParlorGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Funeral Parlor")
@RestController
@RequestMapping("/funeral-parlor")
public class FuneralParlorController {

    private final FuneralParlorGateway funeralParlorGateway;

    public FuneralParlorController(FuneralParlorGateway funeralParlorGateway){
        this.funeralParlorGateway = funeralParlorGateway;
    }

    @GetMapping
    ResponseEntity<?> getFuneralParlors(){
        List<FuneralParlorResponse> responses = this.funeralParlorGateway.getFuneralParlors();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getFuneralParlors(@PathVariable Long id){
        FuneralParlorResponse response = this.funeralParlorGateway.getFuneralParlor(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/update/{id}")
    ResponseEntity<?> updateFuneralPlan(@PathVariable Long id, @RequestBody FuneralParlorRequest funeralParlorRequest){
        this.funeralParlorGateway.updateFuneralParlor(id, funeralParlorRequest);
        return ResponseEntity.ok().build();
    }
    @PostMapping(path = "/create")
    ResponseEntity<?> createFuneralParlor(@RequestBody FuneralParlorRequest funeralParlorRequest){
        this.funeralParlorGateway.createFuneralParlor(funeralParlorRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteFuneralParlor(@PathVariable Long id){
        this.funeralParlorGateway.deleteFuneralParlor(id);
        return ResponseEntity.ok().build();
    }
}
