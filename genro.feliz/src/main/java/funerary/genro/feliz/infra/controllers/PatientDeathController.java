package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.requests.FuneralParlorRequest;
import funerary.genro.feliz.app.models.requests.PatientDeathRequest;
import funerary.genro.feliz.app.models.responses.PatientDeathResponse;
import funerary.genro.feliz.app.usecases.PatientDeathGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Patient Death")
@RestController
@RequestMapping("/patient-death")
public class PatientDeathController {

    private final PatientDeathGateway patientDeathGateway;

    public PatientDeathController(PatientDeathGateway patientDeathGateway){
        this.patientDeathGateway = patientDeathGateway;
    }

    @GetMapping
    ResponseEntity<?> getPatientsDeaths(){
        List<PatientDeathResponse> responses = this.patientDeathGateway.getPatientsDeaths();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<?> getPatientDeath(@PathVariable Long id){
        PatientDeathResponse response = this.patientDeathGateway.getPatientDeath(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/update/{id}")
    ResponseEntity<?> updatePatientDeath(@PathVariable Long id, @RequestBody PatientDeathRequest patientDeathRequest){
        this.patientDeathGateway.updatePatientDeath(id, patientDeathRequest);
        return ResponseEntity.ok().build();
    }
    @PostMapping(path = "/create")
    ResponseEntity<?> createPatientDeath(@RequestBody PatientDeathRequest patientDeathRequest){
        this.patientDeathGateway.createPatientDeath(patientDeathRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deletePatientDeath(@PathVariable Long id){
        this.patientDeathGateway.deletePatientDeath(id);
        return ResponseEntity.ok().build();
    }
}
