package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.ClientRequest;
import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.models.responses.DiscountResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientGateway {

    List<ClientResponse> getClients();

    ClientResponse getClient(Long id);

    void createClient(ClientRequest clientRequest);

    void updateClient(Long id, ClientRequest clientRequest);


    DiscountResponse getDiscountClient(Long id);

    ResponseEntity<byte[]> getReportClientDeath();

    void deleteClient(Long id);
}
