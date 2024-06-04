package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.PatientDeathRequest;
import funerary.genro.feliz.app.models.responses.FuneralParlorResponse;
import funerary.genro.feliz.app.models.responses.PatientDeathResponse;
import funerary.genro.feliz.app.repositories.PatientDeathRepository;
import funerary.genro.feliz.app.usecases.PatientDeathGateway;
import funerary.genro.feliz.domain.FuneralParlor;
import funerary.genro.feliz.domain.PatientDeath;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientDeathImpl implements PatientDeathGateway {

    private final PatientDeathRepository patientDeathRepository;

    public PatientDeathImpl(PatientDeathRepository patientDeathRepository){
        this.patientDeathRepository = patientDeathRepository;
    }
    @Override
    public List<PatientDeathResponse> getPatientsDeaths() {
        List<PatientDeath> patientDeaths = this.patientDeathRepository.findAll();
        return patientDeaths.stream().map(PatientDeathResponse::from).collect(Collectors.toList());
    }

    @Override
    public PatientDeathResponse getPatientDeath(Long id) {
        Optional<PatientDeath> optionalPatientDeath = this.patientDeathRepository.findById(id);
        PatientDeath patientDeath;
        if (optionalPatientDeath.isEmpty()) {
            throw new ClientNotFoundException("Morte de Paciente não Encontrada!");
        } else {
            patientDeath = optionalPatientDeath.get();
        }

        return PatientDeathResponse.from(patientDeath);
    }

    @Override
    public void createPatientDeath(PatientDeathRequest patientDeathRequest) {
        PatientDeath newPatientDeath = new PatientDeath();
        newPatientDeath.setClient(patientDeathRequest.getClient());
        newPatientDeath.setDescriptionDeath(patientDeathRequest.getDescriptionDeath());
        newPatientDeath.setCoffin(patientDeathRequest.getCoffin());
        newPatientDeath.setFuneralParlor(patientDeathRequest.getFuneralParlor());
        newPatientDeath.setChemicalConservation(patientDeathRequest.getChemicalConservation());
        this.patientDeathRepository.save(newPatientDeath);
    }

    @Override
    public void updatePatientDeath(Long id, PatientDeathRequest patientDeathRequest) {
        Optional<PatientDeath> optionalPatientDeath = this.patientDeathRepository.findById(id);
        PatientDeath patientDeath;
        if (optionalPatientDeath.isEmpty()) {
            throw new ClientNotFoundException("Morte de Paciente não Encontrada!");
        } else {
            patientDeath = optionalPatientDeath.get();
            patientDeath.setClient(patientDeathRequest.getClient());
            patientDeath.setDescriptionDeath(patientDeathRequest.getDescriptionDeath());
            patientDeath.setCoffin(patientDeathRequest.getCoffin());
            patientDeath.setFuneralParlor(patientDeathRequest.getFuneralParlor());
            patientDeath.setChemicalConservation(patientDeathRequest.getChemicalConservation());
            this.patientDeathRepository.save(patientDeath);
        }
    }

    @Override
    public void deletePatientDeath(Long id) {
        Optional<PatientDeath> optionalPatientDeath = this.patientDeathRepository.findById(id);
        if (optionalPatientDeath.isEmpty()) {
            throw new ClientNotFoundException("Morte de Paciente não Encontrada!");
        } else {
            this.patientDeathRepository.deleteById(id);
        }
    }
}
