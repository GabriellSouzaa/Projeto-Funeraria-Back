package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.ClientRequest;
import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.repositories.ClientRepository;
import funerary.genro.feliz.app.usecases.ClientGateway;
import funerary.genro.feliz.domain.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientImpl implements ClientGateway {

    private final ClientRepository clientRepository;

    public ClientImpl(ClientRepository clientRepository){ this.clientRepository = clientRepository;}


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

    @Override
    public void createClient(ClientRequest clientRequest) {
        Client newClient = new Client();
        newClient.setNome(clientRequest.getNome());
        newClient.setDataNascimento(clientRequest.getDataNascimento());
        newClient.setCidadeNascimento(clientRequest.getCidadeNascimento());
        newClient.setRg(clientRequest.getRg());
        newClient.setCpf(clientRequest.getCpf());
        newClient.setProfissao(clientRequest.getProfissao());
        newClient.setReligiao(clientRequest.getReligiao());
        newClient.setEstadoCivil(clientRequest.getEstado_civil());
        newClient.setTelefone(clientRequest.getTelefone());
        this.clientRepository.save(newClient);
    }

    @Override
    public void deleteClient(Long id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if (optionalClient.isEmpty()) {
            throw new ClientNotFoundException("Cliente não Encontrado");
        } else {
            this.clientRepository.deleteById(optionalClient.get().getId());
        }
    }
}
