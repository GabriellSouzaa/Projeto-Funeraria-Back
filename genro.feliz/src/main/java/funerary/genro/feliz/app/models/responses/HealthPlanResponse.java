package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.FuneralPlan;
import funerary.genro.feliz.domain.HealthPlan;
import lombok.Getter;

@Getter
public class HealthPlanResponse {

    private Long id;

    private String descricao;

    private String telefone;

    private Float valor;

    private HealthPlanResponse(HealthPlan healthPlan){
        this.id = healthPlan.getId();
        this.descricao = healthPlan.getDescricao();
        this.telefone = healthPlan.getTelefone();
        this.valor = healthPlan.getValor();
    }

    public static HealthPlanResponse from(HealthPlan healthPlan){
        return new HealthPlanResponse(healthPlan);
    }

}
