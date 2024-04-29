package funerary.genro.feliz.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "endereco_cliente")
@Entity
@Getter
public class EnderecoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "endereco_residencial")
    private String enderecoResidencial;

    private String bairro;

    private String cidade;

    private String cep;

    private String estado;

}
