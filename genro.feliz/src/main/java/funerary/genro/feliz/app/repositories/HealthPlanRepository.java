package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.HealthPlan;
import funerary.genro.feliz.domain.PatientDeath;

import java.util.List;
import java.util.Optional;

public interface HealthPlanRepository {

    List<HealthPlan> findAll();

    Optional<HealthPlan> findById(Long id);

    void save(HealthPlan newHealthPlan);

    void deleteById(Long id);
}
