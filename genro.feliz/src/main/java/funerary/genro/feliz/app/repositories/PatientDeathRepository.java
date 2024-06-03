package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.PatientDeath;

import java.util.List;
import java.util.Optional;

public interface PatientDeathRepository {

    List<PatientDeath> findAll();

    Optional<PatientDeath> findById(Long id);

    void save(PatientDeath newPatientDeath);

    void deleteById(Long id);
}
