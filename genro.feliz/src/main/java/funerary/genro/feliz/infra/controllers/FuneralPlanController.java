package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.requests.FuneralPlanRequest;
import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;
import funerary.genro.feliz.app.usecases.FuneralPlanGateway;
import funerary.genro.feliz.domain.FuneralPlan;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Funeral Plan")
@RestController
@RequestMapping("/funeral-plan")
public class FuneralPlanController {

    private final FuneralPlanGateway funeralPlanGateway;

    public FuneralPlanController(FuneralPlanGateway findFuneralPlan){
        this.funeralPlanGateway = findFuneralPlan;
    }

    @GetMapping
    ResponseEntity<?> getFuneralPlans(){
        List<FuneralPlanResponse> responses = this.funeralPlanGateway.getFuneralPlans();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/atrasados")
    ResponseEntity<?> getDelayedFuneralPlans(){
        List<DelayedFuneralPlanResponse> responses = this.funeralPlanGateway.getDelayedFuneralPlans();
        return ResponseEntity.ok(responses);
    }
    @PostMapping(path = "/update/{id}")
    ResponseEntity<?> updateFuneralPlan(@PathVariable Long id, @RequestBody FuneralPlanRequest funeralPlanRequest){
        this.funeralPlanGateway.updateFuneralPlan(id, funeralPlanRequest);
        return ResponseEntity.ok().build();
    }
    @PostMapping(path = "/create")
    ResponseEntity<?> createFuneralPlan(@RequestBody FuneralPlanRequest funeralPlanRequest){
        this.funeralPlanGateway.createFuneralPlan(funeralPlanRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteFuneralPlans(@PathVariable Long id){
        this.funeralPlanGateway.deleteFuneralPlan(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/report/delayed-plan")
    ResponseEntity<?> getReportDelayedPlan(){
        return this.funeralPlanGateway.getReportDelayedFuneralPlans();
    }
}
