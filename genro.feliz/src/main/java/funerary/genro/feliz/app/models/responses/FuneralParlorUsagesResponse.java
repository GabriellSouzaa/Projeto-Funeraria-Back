package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.FuneralParlor;
import funerary.genro.feliz.domain.FuneralParlorUsages;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FuneralParlorUsagesResponse {


    private Long id;

    private String funeralParlor;

    private String uso;

    private LocalDate dataUso;

    public FuneralParlorUsagesResponse(FuneralParlorUsages funeralParlorUsages){
        this.id = funeralParlorUsages.getId();
        this.funeralParlor = funeralParlorUsages.getFuneralParlor().getDescricao();
        this.uso = funeralParlorUsages.getUso();
        this.dataUso = funeralParlorUsages.getDataUso();
    }

    public static FuneralParlorUsagesResponse from(FuneralParlorUsages funeralParlorUsages){
        return new FuneralParlorUsagesResponse(funeralParlorUsages);
    }
}
