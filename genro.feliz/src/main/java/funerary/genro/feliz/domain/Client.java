package funerary.genro.feliz.domain;


import jakarta.persistence.*;

import lombok.Getter;



import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String cidadeNascimento;

    private String rg;

    private String cpf;

    private String profissao;

    private String religiao;

    private String estadoCivil;

    private Long telefone;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private EnderecoCliente endereco;


}