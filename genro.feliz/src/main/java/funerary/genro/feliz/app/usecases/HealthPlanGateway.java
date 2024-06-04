package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.FuneralPlanRequest;
import funerary.genro.feliz.app.models.requests.HealthPlanRequest;
import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.HealthPlanResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HealthPlanGateway {

    List<HealthPlanResponse> getHealthPlans();

    HealthPlanResponse getHealthPlan(Long id);


    void updateHealthPlan(Long id, HealthPlanRequest healthPlanRequest);

    void createHealthPlan(HealthPlanRequest healthPlanRequest);

    void deleteHealthPlan(Long id);
}
