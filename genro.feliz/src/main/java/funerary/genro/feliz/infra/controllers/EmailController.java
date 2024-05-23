package funerary.genro.feliz.infra.controllers;


import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.usecases.ClientGateway;
import funerary.genro.feliz.app.usecases.EmailGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "Email")
@RequestMapping("/email")
public class EmailController {

    private final EmailGateway emailGateway;

    public EmailController(EmailGateway emailGateway){
        this.emailGateway = emailGateway;
    }

    @GetMapping
    ResponseEntity<?> sendEmailToDelayedFuneralPlan(@PathVariable String nomeCliente, @PathVariable Long id){
         this.emailGateway.sendEmailToDelayedFuneralPlan(nomeCliente, id);
        return ResponseEntity.ok().build();
    }
}
