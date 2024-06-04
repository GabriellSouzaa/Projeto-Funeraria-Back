package funerary.genro.feliz.app.usecases;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmailGateway {

     void sendEmailToDelayedFuneralPlan(String nomeCliente, Long id);

     void sendEmailToBeneficiariesDeath(Long id);

}
