package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Seller;
import funerary.genro.feliz.domain.SellerSalles;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class SellerSallesResponse {

    private Long id;

    private String nomeVendedor;

    private Long qtdVenda;

    private String tipoVenda;

    private LocalDate dataVenda;

    private SellerSallesResponse(SellerSalles sellerSalles){
        this.id = sellerSalles.getId();
        this.nomeVendedor = sellerSalles.getSeller().getNome();
        this.qtdVenda = sellerSalles.getQtdVenda();
        this.tipoVenda = sellerSalles.getTipoVenda();
        this.dataVenda = sellerSalles.getDataVenda();

    }

    public static SellerSallesResponse from(SellerSalles sellerSalles){
        return new SellerSallesResponse(sellerSalles);
    }
}
