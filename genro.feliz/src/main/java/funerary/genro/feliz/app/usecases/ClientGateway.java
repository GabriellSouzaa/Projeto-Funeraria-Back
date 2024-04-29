package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.responses.ClientResponse;

import java.util.List;

public interface ClientGateway {

    List<ClientResponse> getClients();
    ClientResponse getClient(Long id);
}
