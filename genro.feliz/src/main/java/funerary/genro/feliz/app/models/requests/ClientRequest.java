package funerary.genro.feliz.app.models.requests;

import funerary.genro.feliz.domain.Client;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClientRequest {

    private String nome;

    private LocalDate dataNascimento;

    private String cidadeNascimento;

    private String rg;

    private String cpf;

    private String profissao;

    private String religiao;

    private String estado_civil;

    private Long telefone;


}
