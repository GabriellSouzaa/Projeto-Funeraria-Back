package funerary.genro.feliz.infra.controllers;

import funerary.genro.feliz.app.models.requests.ClientRequest;
import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.models.responses.DiscountResponse;
import funerary.genro.feliz.app.usecases.ClientGateway;
import io.swagger.annotations.Api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Api(tags = "Client")
@RequestMapping("/client")
public class ClientController {

    private final ClientGateway clientGateway;

    public ClientController(ClientGateway clientGateway){
        this.clientGateway = clientGateway;
    }


    @GetMapping
    ResponseEntity<?> getFindClient(){
        List<ClientResponse> responses = this.clientGateway.getClients();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/discount/{id}")
    ResponseEntity<?> getDiscountClient(@PathVariable Long id){
        DiscountResponse responses = this.clientGateway.getDiscountClient(id);
        return ResponseEntity.ok(responses);
    }

    @GetMapping(path = "/{id}")
     ResponseEntity<?> getClient(@PathVariable Long id) {
        ClientResponse response = this.clientGateway.getClient(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/report")
    ResponseEntity<?> getReportClientDeath() {
        return this.clientGateway.getReportClientDeath();
    }

    @PostMapping(path = "/create",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<?> createClient(@ModelAttribute ClientRequest clientRequest){
        this.clientGateway.createClient(clientRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/update/{id}")
    ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody ClientRequest clientRequest){
        this.clientGateway.updateClient(id, clientRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete/{id}")
    ResponseEntity<?> deleteClient(@PathVariable Long id){
        this.clientGateway.deleteClient(id);
        return ResponseEntity.ok().build();
    }


}
