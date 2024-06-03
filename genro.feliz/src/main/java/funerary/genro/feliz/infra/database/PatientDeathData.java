package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.PatientDeath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDeathData extends JpaRepository<PatientDeath, Long> {
}
