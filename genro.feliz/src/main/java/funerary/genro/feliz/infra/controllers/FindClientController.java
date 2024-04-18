package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.usecases.IFindClient;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Client")
@RequestMapping("/client")
public class FindClientController {

    private final IFindClient findClient;

    public FindClientController(IFindClient findClient){
        this.findClient = findClient;
    }


    @GetMapping
    ResponseEntity<?> getFindClient(){
        List<ClientResponse> responses = this.findClient.getClients();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "{id}")
     ResponseEntity<?> getClient(@PathVariable Long id) {
        ClientResponse response = this.findClient.getClient(id);
        return ResponseEntity.ok(response);
    }


}
