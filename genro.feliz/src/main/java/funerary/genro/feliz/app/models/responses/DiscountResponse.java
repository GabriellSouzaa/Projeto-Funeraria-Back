package funerary.genro.feliz.app.models.responses;

import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.FuneralPlan;
import lombok.Getter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
public class DiscountResponse {

    private String descontoCaixao;
    private String descontoSalaVelorio;
    private String planoDeSaude;


    private static final float valorBase = 100.0f;
    private static final float desconto = 0.05f;

    private DiscountResponse(Client client){
        this.descontoCaixao = calculateDiscount(client);
        this.descontoSalaVelorio = calculateDiscount(client);
        this.planoDeSaude = calculateDiscount(client);
    }


    private String calculateDiscount(Client client) {
        FuneralPlan funeralPlan = client.getFuneralPlan();
        if (funeralPlan == null) {
            throw new RuntimeException("Plano não Encontrado");
        }

        LocalDate dataEnvio = funeralPlan.getDataEnvio().toLocalDate();
        LocalDate currentDate = LocalDate.now();
        long monthsBetween = ChronoUnit.MONTHS.between(dataEnvio, currentDate);
        float discount = valorBase - (valorBase * desconto * monthsBetween);

        if (discount < 0) {
            discount = 0;
        }

        return String.format("%.2f", discount);
    }
    public static DiscountResponse from(Client client){
        return new DiscountResponse(client);
    }
}
