package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.*;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Getter
public class PatientDeathResponse {

    private Long id;

    private String funeralParlor;

    private String client;

    private String coffin;

    private String chemicalConservation;

    private String descriptionDeath;

    private PatientDeathResponse(PatientDeath patientDeath){
        this.id = patientDeath.getId();
        this.funeralParlor = patientDeath.getFuneralParlor().getDescricao();
        this.client = patientDeath.getClient().getNome();
        this.coffin = patientDeath.getCoffin().getModelo();
        this.chemicalConservation = patientDeath.getChemicalConservation();
        this.descriptionDeath = patientDeath.getDescriptionDeath();
    }

    public static PatientDeathResponse from(PatientDeath patientDeath){
        return new PatientDeathResponse(patientDeath);
    }


}
