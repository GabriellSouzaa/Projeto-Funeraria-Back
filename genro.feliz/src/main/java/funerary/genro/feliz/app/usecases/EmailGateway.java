package funerary.genro.feliz.app.usecases;

import java.util.Map;

public interface EmailGateway {

     void sendEmailToDelayedFuneralPlan(String nomeCliente, Long id);
}
