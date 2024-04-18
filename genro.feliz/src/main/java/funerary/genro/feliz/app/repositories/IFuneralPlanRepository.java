package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.FuneralPlan;

import java.time.LocalDate;
import java.util.List;

public interface IFuneralPlanRepository {

    List<FuneralPlan> findAll();

    List<FuneralPlan> findDelayedFuneralPlans(String p, LocalDate data);
}
