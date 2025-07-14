package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Client;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClientResponse {

    private final Long id;
    private final String nome;
    private final LocalDate dataNascimento;
    private final String cidadeNascimento;
    private final String rg;
    private final byte[] imagem;
    private final String cpf;
    private final String profissao;
    private final String religiao;
    private final String estadoCivil;
    private final Long telefone;


    private ClientResponse(Client client) {
        this.id = client.getId();
        this.nome = client.getNome();
        this.dataNascimento = client.getDataNascimento();
        this.cidadeNascimento = client.getCidadeNascimento();
        this.rg = client.getRg();
        this.cpf = client.getCpf();
        this.profissao = client.getProfissao();
        this.religiao = client.getReligiao();
        this.estadoCivil = client.getEstadoCivil();
        this.telefone = client.getTelefone();
        this.imagem = client.getImagem();
    }

    public static ClientResponse from(Client client){ return new ClientResponse(client);}
}
