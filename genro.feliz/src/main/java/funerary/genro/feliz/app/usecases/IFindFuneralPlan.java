package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;

import java.util.List;

public interface IFindFuneralPlan {

    List<FuneralPlanResponse> getFuneralPlans();

    List<DelayedFuneralPlanResponse> getDelayedFuneralPlans();
}
