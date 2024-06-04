package funerary.genro.feliz.domain;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String cidadeNascimento;

    private String email;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private FuneralPlan funeralPlan;

    private String rg;

    private String cpf;

    private String profissao;

    private String religiao;

    private String estadoCivil;

    private String ativo;

    private Long telefone;




}