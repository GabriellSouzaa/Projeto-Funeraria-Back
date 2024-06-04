package funerary.genro.feliz.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "seller_salles")
@Getter
@Setter
public class SellerSalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Seller seller;

    private Long qtdVenda;

    private String tipoVenda;

    private LocalDate dataVenda;

}
