package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;
import funerary.genro.feliz.app.usecases.FuneralPlanGateway;
import funerary.genro.feliz.domain.FuneralPlan;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/funeral-plan")
public class FuneralPlanController {

    private final FuneralPlanGateway findFuneralPlan;

    public FuneralPlanController(FuneralPlanGateway findFuneralPlan){
        this.findFuneralPlan = findFuneralPlan;
    }

    @GetMapping
    ResponseEntity<?> getFuneralPlans(){
        List<FuneralPlanResponse> responses = this.findFuneralPlan.getFuneralPlans();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/atrasados")
    ResponseEntity<?> getDelayedFuneralPlans(){
        List<DelayedFuneralPlanResponse> responses = this.findFuneralPlan.getDelayedFuneralPlans();
        return ResponseEntity.ok(responses);
    }
}
