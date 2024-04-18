package funerary.genro.feliz.app.models.requests;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FuneralPlanRequest {

    private LocalDateTime dataEnvio;

    private Float valor;

    private String nomeCliente;

}
