package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.repositories.BeneficiaryRepository;
import funerary.genro.feliz.app.repositories.ClientRepository;
import funerary.genro.feliz.app.repositories.FuneralPlanRepository;
import funerary.genro.feliz.app.usecases.EmailGateway;
import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.FuneralPlan;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class EmailImpl implements EmailGateway {

    private final JavaMailSender javaMailSender;

    private final SpringTemplateEngine thymeleafTemplateEngine;

    private final ClientRepository clientRepository;

    private final FuneralPlanRepository funeralPlanRepository;

    private final BeneficiaryRepository beneficiaryRepository;




    public EmailImpl(JavaMailSender javaMailSender,BeneficiaryRepository beneficiaryRepository, FuneralPlanRepository funeralPlanRepository, ClientRepository clientRepository, SpringTemplateEngine thymeleafTemplateEngine){
        this.javaMailSender = javaMailSender;
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
        this.clientRepository = clientRepository;
        this.funeralPlanRepository = funeralPlanRepository;
        this.beneficiaryRepository = beneficiaryRepository;

    }

    @Value("${spring.mail.username}")
    private String email;

    @Override
    public void sendEmailToDelayedFuneralPlan(String nomeCliente, Long id) {
        Optional<Client> client = this.clientRepository.findByNome(nomeCliente);
        if (client.isEmpty()) {
            throw new ClientNotFoundException("Cliente não Encontrado");
        }
        Optional<FuneralPlan> funeralPlan = this.funeralPlanRepository.findById(id);
        if (funeralPlan.isEmpty()) {
            throw new ClientNotFoundException("Plano Funeral não Encontrado");
        }

        sendEmail(client,funeralPlan);
    }

    @Override
    public void sendEmailToBeneficiariesDeath(Long id) {
        Optional<Beneficiary> optionalBeneficiary = this.beneficiaryRepository.findById(id);
        Beneficiary beneficiary;
        if (optionalBeneficiary.isEmpty()) {
            throw new ClientNotFoundException("Beneficiário não Encontrado");
        } else {
            beneficiary = optionalBeneficiary.get();
        }
        Optional<Client> client = this.clientRepository.findByNome(beneficiary.getClient().getNome());
        if (client.isEmpty()) {
            throw new ClientNotFoundException("Cliente não Encontrado");
        } else {
            sendEmailToClient(client, optionalBeneficiary);

        }
    }

    public void sendEmailToClient(Optional<Client> client,  Optional<Beneficiary> optionalBeneficiary ){
        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("name", client.get().getNome());
        templateModel.put("nomeBeneficiary", optionalBeneficiary.get().getNome());
        templateModel.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariables(templateModel);

            String htmlContent = thymeleafTemplateEngine.process("beneficiario-inativo.html", context);

            helper.setFrom(email);
            helper.setTo(client.get().getEmail());
            helper.setSubject("Beneficiario Inativo");
            helper.setText(htmlContent, true);

            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void sendEmail(Optional<Client> client, Optional<FuneralPlan> funeralPlan) {
        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("name", client.get().getNome());
        templateModel.put("valorAPagar", CalculateDelayedPlan.valorAPagar(funeralPlan.get()));
        templateModel.put("diasAtrasado", CalculateDelayedPlan.calcularDiasAtraso(funeralPlan.get()));

        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariables(templateModel);

            String htmlContent = thymeleafTemplateEngine.process("genro-feliz.html", context);

            helper.setFrom(email);
            helper.setTo(client.get().getEmail());
            helper.setSubject("Plano Funeral Atrasado");
            helper.setText(htmlContent, true);

            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

