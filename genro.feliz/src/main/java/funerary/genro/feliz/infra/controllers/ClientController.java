package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.requests.ClientRequest;
import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.usecases.ClientGateway;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Client")
@RequestMapping("/client")
public class ClientController {

    private final ClientGateway clientGateway;

    public ClientController(ClientGateway findClient){
        this.clientGateway = findClient;
    }


    @GetMapping
    ResponseEntity<?> getFindClient(){
        List<ClientResponse> responses = this.clientGateway.getClients();
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
     ResponseEntity<?> getClient(@PathVariable Long id) {
        ClientResponse response = this.clientGateway.getClient(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/create")
    ResponseEntity<?> createClient(@RequestBody ClientRequest clientRequest){
        this.clientGateway.createClient(clientRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteClient(@PathVariable Long id){
        this.clientGateway.deleteClient(id);
        return ResponseEntity.ok().build();
    }


}
