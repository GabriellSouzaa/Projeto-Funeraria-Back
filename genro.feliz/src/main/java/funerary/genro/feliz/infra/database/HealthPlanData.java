package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.HealthPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthPlanData extends JpaRepository<HealthPlan, Long> {
}
