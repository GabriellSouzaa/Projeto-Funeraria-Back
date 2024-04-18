package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.ClientNotFoundException;
import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.repositories.IClientRepository;
import funerary.genro.feliz.app.usecases.IFindClient;
import funerary.genro.feliz.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FindClient implements IFindClient {

    private final IClientRepository clientRepository;

    public FindClient(IClientRepository clientRepository){ this.clientRepository = clientRepository;}


    @Override
    public List<ClientResponse> getClients() {
       List<Client> clients = this.clientRepository.findAll();
       return clients.stream().map(ClientResponse::from).collect(Collectors.toList());
    }

    @Override
    public ClientResponse getClient(Long id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        Client client;
        if (optionalClient.isEmpty()) {
            throw new ClientNotFoundException("Cliente não Encontrado");
        } else {
            client = optionalClient.get();
        }

        return ClientResponse.from(client);
    }
}
