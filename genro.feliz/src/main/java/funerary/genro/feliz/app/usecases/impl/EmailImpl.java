package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.models.requests.EmailRequest;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;
import funerary.genro.feliz.domain.FuneralPlan;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.math.BigDecimal;

public class EmailImpl {
    private final JavaMailSender mailSender;

    public EmailImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmailToDelayedPlans(FuneralPlan funeralPlan, Long diasAtrasado, BigDecimal valorAPagar){
        var message = new SimpleMailMessage();
        message.setFrom("genroFeliz@gmail.com");
        message.setTo(funeralPlan.getClient().getEmail());
        message.setSubject("Plano Funeral se Encontra atrasado");
        message.setText("Entramos em contato para avisar que o Plano Funeral no nome de " + funeralPlan.getClient().getNome()
                + "se encontra atrasado á " + diasAtrasado + " e com o juros o valor mensal se encontra em " + valorAPagar
        );
        mailSender.send(message);

    }
}
