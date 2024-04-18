package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.domain.Client;

import java.util.List;
import java.util.Optional;

public interface IFindClient {

    List<ClientResponse> getClients();
    ClientResponse getClient(Long id);
}
