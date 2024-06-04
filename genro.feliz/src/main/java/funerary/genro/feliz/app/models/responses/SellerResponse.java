package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Seller;
import lombok.Getter;

@Getter
public class SellerResponse {

    private Long id;

    private String nome;

    private String cargo;

    private SellerResponse(Seller seller){
        this.id = seller.getId();
        this.cargo = seller.getCargo();
        this.nome = seller.getNome();

    }

    public static SellerResponse from(Seller seller){
        return new SellerResponse(seller);
    }
}
