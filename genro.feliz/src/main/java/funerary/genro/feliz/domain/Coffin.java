package funerary.genro.feliz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coffin")
@Getter
@Setter
public class Coffin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String material;

    private String cor;

    private String comprimento;

    private String modelo;

    private Float preco;
}
