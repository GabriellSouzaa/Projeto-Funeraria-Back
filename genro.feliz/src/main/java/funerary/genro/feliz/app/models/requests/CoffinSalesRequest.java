package funerary.genro.feliz.app.models.requests;

import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.Seller;
import lombok.Getter;


import java.time.LocalDate;

@Getter
public class CoffinSalesRequest {

    private Client client;

    private Seller seller;

    private Coffin coffin;

    private LocalDate dataVenda;
}
