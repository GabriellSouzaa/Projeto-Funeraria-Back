package funerary.genro.feliz.cadastroCliente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "endereco_cliente")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne
    private Cliente cliente;
}
