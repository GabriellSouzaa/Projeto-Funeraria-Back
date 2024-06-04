package funerary.genro.feliz.app.models.requests;

import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.FuneralParlor;
import lombok.Getter;

@Getter
public class PatientDeathRequest {

    private FuneralParlor funeralParlor;

    private Client client;

    private Coffin coffin;

    private String chemicalConservation;

    private String descriptionDeath;
}
