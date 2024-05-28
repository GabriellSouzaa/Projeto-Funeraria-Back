package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.domain.Client;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class BeneficiaryResponse {

    private Long id;

    private Long client;

    private String nomeClient;

    private String nome;

    private LocalDate dataNascimento;

    private Float adicional;

    private BeneficiaryResponse(Beneficiary beneficiary) {
        this.id = beneficiary.getId();
        this.nome = beneficiary.getNome();
        this.dataNascimento = beneficiary.getDataNascimento();
        this.client = beneficiary.getClient().getId();
        this.nomeClient = beneficiary.getClient().getNome();
        this.adicional = beneficiary.getAdicional();
    }

    public static BeneficiaryResponse from(Beneficiary beneficiary){ return new BeneficiaryResponse(beneficiary);}
}
