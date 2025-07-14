package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.usecases.ApiGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class IaController {

    private final ApiGateway apiGateway;

    public IaController(ApiGateway apiGateway) {
        this.apiGateway = apiGateway;
    }

    @GetMapping("/generate/{request}")
    public String generateResponse(@PathVariable String request){
        String requestBody = "{\"contents\":[{\"parts\":[{\"text\":\"" + request + "\"}]}]}";
        return apiGateway.generateContent(requestBody);
    }
}
