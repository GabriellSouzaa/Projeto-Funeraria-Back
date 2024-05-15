package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.FuneralPlanRequest;
import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;

import java.util.List;

public interface FuneralPlanGateway {

    List<FuneralPlanResponse> getFuneralPlans();

    List<DelayedFuneralPlanResponse> getDelayedFuneralPlans();

    void createFuneralPlan(FuneralPlanRequest funeralPlanRequest);

    void deleteFuneralPlan(Long id);
}
