package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.ClientRequest;
import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.models.responses.CoffinSalesResponse;
import funerary.genro.feliz.app.models.responses.DiscountResponse;
import funerary.genro.feliz.app.repositories.ClientRepository;
import funerary.genro.feliz.app.usecases.ClientGateway;
import funerary.genro.feliz.domain.Client;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
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
    public void updateClient(Long id, ClientRequest clientRequest) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if (optionalClient.isEmpty()) {
            throw new ClientNotFoundException("Cliente não Encontrado");
        } else {
            Client client = optionalClient.get();
            client.setNome(clientRequest.getNome());
            client.setDataNascimento(clientRequest.getDataNascimento());
            client.setCidadeNascimento(clientRequest.getCidadeNascimento());
            client.setRg(clientRequest.getRg());
            client.setCpf(clientRequest.getCpf());
            client.setProfissao(clientRequest.getProfissao());
            client.setReligiao(clientRequest.getReligiao());
            client.setEstadoCivil(clientRequest.getEstado_civil());
            client.setTelefone(clientRequest.getTelefone());
            this.clientRepository.save(client);
        }
    }

    @Override
    public DiscountResponse getDiscountClient(Long id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if (optionalClient.isEmpty()) {
            throw new ClientNotFoundException("Cliente não Encontrado");
        } else {
            return DiscountResponse.from(optionalClient.get());
        }

    }

    public List<ClientResponse> getClientsUnactive(){
        List<Client> clients = this.clientRepository.findAllByAtivo("N");
        return clients.stream().map(ClientResponse::from).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<byte[]> getReportClientDeath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("relatorios/clientes-mortos.jrxml")).getFile());

        List<ClientResponse> clients = this.getClientsUnactive();

        LocalDateTime dataEmissao = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataEmissaoFormatada = dataEmissao.format(formatter);

        JRBeanCollectionDataSource clientsDealth = new JRBeanCollectionDataSource(clients);
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("clientsDealth", clientsDealth);
        parametros.put("dataEmissaoFormatada", dataEmissaoFormatada);


        byte[] bytes = ReportUtilsImpl.geraRelatorioEmPDF(file.getAbsolutePath(), parametros);

        return ReportUtilsImpl.retornaResponseEntityRelatorio(bytes);
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
