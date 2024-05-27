package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.Coffin;
import lombok.Getter;

@Getter
public class CoffinResponse {

    private Long id;

    private String material;

    private String cor;

    private String comprimento;

    private String modelo;

    private Float preco;

    public CoffinResponse(Coffin coffin){
        this.id = coffin.getId();
        this.material = coffin.getMaterial();
        this.cor = coffin.getCor();
        this.comprimento = coffin.getComprimento();
        this.modelo = coffin.getModelo();
        this.preco = coffin.getPreco();
    }

    public static CoffinResponse from(Coffin coffin){ return new CoffinResponse(coffin);}
}
