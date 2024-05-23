package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.app.usecases.impl.CalculateDelayedPlan;
import funerary.genro.feliz.domain.FuneralPlan;
import lombok.Getter;


@Getter
public class DelayedFuneralPlanResponse {

    private Long id;

    private String tempoAtrasado;

    private String nomeCliente;

    private String cpfCliente;

    private Float valorAPagar;

    private DelayedFuneralPlanResponse(FuneralPlan funeralPlan){
        this.id = funeralPlan.getId();
        this.tempoAtrasado = CalculateDelayedPlan.calcularDiasAtraso(funeralPlan);
        this.nomeCliente = funeralPlan.getClient().getNome();
        this.cpfCliente = funeralPlan.getClient().getCpf();
        this.valorAPagar = CalculateDelayedPlan.valorAPagar(funeralPlan);
    }


    public static DelayedFuneralPlanResponse from(FuneralPlan funeralPlan){
        return new DelayedFuneralPlanResponse(funeralPlan);
    }


}
