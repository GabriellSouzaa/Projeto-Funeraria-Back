package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.FuneralParlor;
import lombok.Getter;

@Getter
public class FuneralParlorResponse {

    private Long id;

    private String descricao;

    private Float valor;

    public FuneralParlorResponse(FuneralParlor funeralParlor){
        this.id = funeralParlor.getId();
        this.descricao = funeralParlor.getDescricao();
        this.valor = funeralParlor.getValor();
    }

    public static FuneralParlorResponse from(FuneralParlor funeralParlor){
        return new FuneralParlorResponse(funeralParlor);
    }
}
