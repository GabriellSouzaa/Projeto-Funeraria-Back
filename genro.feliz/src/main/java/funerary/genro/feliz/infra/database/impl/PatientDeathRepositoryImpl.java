package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.PatientDeathRepository;
import funerary.genro.feliz.domain.PatientDeath;
import funerary.genro.feliz.infra.database.PatientDeathData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientDeathRepositoryImpl implements PatientDeathRepository {

    private final PatientDeathData patientDeathData;

    public PatientDeathRepositoryImpl(PatientDeathData patientDeathData){
        this.patientDeathData = patientDeathData;
    }

    @Override
    public List<PatientDeath> findAll() {
        return this.patientDeathData.findAll();
    }

    @Override
    public Optional<PatientDeath> findById(Long id) {
        return this.patientDeathData.findById(id);
    }

    @Override
    public void save(PatientDeath newPatientDeath) {
        this.patientDeathData.save(newPatientDeath);
    }

    @Override
    public void deleteById(Long id) {
        this.patientDeathData.deleteById(id);
    }
}
