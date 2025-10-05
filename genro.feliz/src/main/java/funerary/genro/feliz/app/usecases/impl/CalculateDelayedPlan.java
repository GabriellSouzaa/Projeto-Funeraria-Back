package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.domain.FuneralPlan;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

@Service
public class CalculateDelayedPlan {

    public static String valorAPagar(FuneralPlan funeralPlan) {
        Float valor = funeralPlan.getValor();
        LocalDate hoje = LocalDate.now();

        if (hoje.isAfter(funeralPlan.getDataPagamento())) {
            long mesesAtraso = ChronoUnit.MONTHS.between(
                    funeralPlan.getDataPagamento().withDayOfMonth(1),
                    hoje.withDayOfMonth(1)
            );
            double taxaJuros = 0.05;
            valor = (float) (valor * Math.pow(1 + taxaJuros, mesesAtraso));
            System.out.println("Valor com juros: " + valor);
        }

        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(valor);
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
