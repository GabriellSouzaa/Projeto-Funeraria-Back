package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.domain.FuneralPlan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class CalculateDelayedPlan {

    public static Float valorAPagar(FuneralPlan funeralPlan){
        Float valor = funeralPlan.getValor();
        LocalDate hoje = LocalDate.now();
        if(hoje.isAfter(funeralPlan.getDataPagamento())){
            long diasAtraso = ChronoUnit.DAYS.between(funeralPlan.getDataPagamento(), hoje);
            double taxaJuros = 0.05;
            return (float) (valor * Math.pow(1 + taxaJuros, diasAtraso));
        }
        return valor;
    }

    public static String calcularDiasAtraso(FuneralPlan funeralPlan) {
        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(funeralPlan.getDataPagamento())) {
            Long diasAtraso = ChronoUnit.DAYS.between(funeralPlan.getDataPagamento(), hoje);
            return "O Plano está atrasado à " + diasAtraso + " dias";
        }
        return "O Plano está dentro do Prazo de pagamento";
    }
}
