package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.PatientDeathRequest;
import funerary.genro.feliz.app.models.requests.SellerRequest;
import funerary.genro.feliz.app.models.responses.PatientDeathResponse;
import funerary.genro.feliz.app.models.responses.SellerResponse;

import java.util.List;

public interface PatientDeathGateway {

    List<PatientDeathResponse> getPatientsDeaths();

    PatientDeathResponse getPatientDeath(Long id);

    void createPatientDeath(PatientDeathRequest patientDeathRequest);

    void updatePatientDeath(Long id, PatientDeathRequest patientDeathRequest);

    void deletePatientDeath(Long id);
}
