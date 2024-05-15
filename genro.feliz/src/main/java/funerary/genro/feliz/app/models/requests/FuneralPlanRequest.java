package funerary.genro.feliz.app.models.requests;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class FuneralPlanRequest {

    private LocalDateTime dataEnvio;

    private Float valor;

    private LocalDate dataPagamento;

    private String nomeCliente;

}
