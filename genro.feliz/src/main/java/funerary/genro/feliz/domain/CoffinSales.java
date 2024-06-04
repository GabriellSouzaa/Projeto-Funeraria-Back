package funerary.genro.feliz.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "coffin_salles")
@Getter
@Setter
public class CoffinSales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Seller seller;

    @ManyToOne
    private Coffin coffin;

    private LocalDate dataVenda;

    @ManyToOne
    private Client client;

}
