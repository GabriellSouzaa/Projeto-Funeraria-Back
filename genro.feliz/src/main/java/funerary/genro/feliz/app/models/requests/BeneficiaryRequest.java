package funerary.genro.feliz.app.models.requests;

import funerary.genro.feliz.domain.Client;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BeneficiaryRequest {


    private Client client;

    private String nome;

    private LocalDate dataNascimento;

    private Float adicional;
}
