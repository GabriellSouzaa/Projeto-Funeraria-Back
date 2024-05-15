package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.FuneralPlan;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FuneralPlanRepository {

    List<FuneralPlan> findAll();

    List<FuneralPlan> findDelayedFuneralPlans(String p, LocalDate data);

    Optional<FuneralPlan> findById(Long id);

    void save(FuneralPlan funeralPlan);

    void deleteById(Long id);


}
