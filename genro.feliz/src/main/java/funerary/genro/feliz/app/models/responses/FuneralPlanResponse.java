package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.app.models.requests.FuneralPlanRequest;
import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.FuneralPlan;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FuneralPlanResponse {

    private Long id;

    private LocalDateTime dataEnvio;

    private Float valor;

    private String clientNome;

    private FuneralPlanResponse(FuneralPlan funeralPlan){
        this.id = funeralPlan.getId();
        this.dataEnvio = funeralPlan.getDataEnvio();
        this.valor = funeralPlan.getValor();
        this.clientNome = funeralPlan.getClient().getNome();

    }

    public static FuneralPlanResponse from(FuneralPlan funeralPlan){
        return new FuneralPlanResponse(funeralPlan);
    }
}
