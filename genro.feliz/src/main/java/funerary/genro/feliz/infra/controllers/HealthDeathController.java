package funerary.genro.feliz.infra.controllers;


import funerary.genro.feliz.app.models.requests.HealthPlanRequest;
import funerary.genro.feliz.app.models.requests.PatientDeathRequest;
import funerary.genro.feliz.app.models.responses.HealthPlanResponse;
import funerary.genro.feliz.app.models.responses.PatientDeathResponse;
import funerary.genro.feliz.app.usecases.HealthPlanGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Health Death")
@RestController
@RequestMapping("/health-death")
public class HealthDeathController {

    private final HealthPlanGateway healthPlanGateway;

    public HealthDeathController(HealthPlanGateway healthPlanGateway){
        this.healthPlanGateway = healthPlanGateway;
    }

    @GetMapping
    ResponseEntity<?> getHealthPlans(){
        List<HealthPlanResponse> responses = this.healthPlanGateway.getHealthPlans();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getHealthPlan(@PathVariable Long id){
        HealthPlanResponse response = this.healthPlanGateway.getHealthPlan(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/create")
    ResponseEntity<?> createHealthPlan(@RequestBody HealthPlanRequest healthPlanRequest){
        this.healthPlanGateway.createHealthPlan(healthPlanRequest);
        return ResponseEntity.ok().build();
    }


    @PutMapping(path = "/update/{id}")
    ResponseEntity<?> updateHealthPlan(@PathVariable Long id, @RequestBody HealthPlanRequest healthPlanRequest){
        this.healthPlanGateway.updateHealthPlan(id, healthPlanRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteHealthPlan(@PathVariable Long id){
        this.healthPlanGateway.deleteHealthPlan(id);
        return ResponseEntity.ok().build();
    }
}
