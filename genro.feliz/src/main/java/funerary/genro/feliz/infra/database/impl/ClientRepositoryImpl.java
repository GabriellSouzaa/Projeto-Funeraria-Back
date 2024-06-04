package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.ClientRepository;
import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.infra.database.ClientData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientData clientData;

    public ClientRepositoryImpl(ClientData clientData){ this.clientData = clientData;}
    @Override
    public List<Client> findAll() {
        return this.clientData.findAll();
    }

    @Override
    public List<Client> findAllByAtivo(String ativo) {
        return this.clientData.findAllByAtivo(ativo);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return this.clientData.findById(id);
    }

    @Override
    public Optional<Client> findByNome(String nome) {
        return this.clientData.findByNome(nome);
    }

    @Override
    public void save(Client newClient) {
        this.clientData.save(newClient);
    }

    @Override
    public void deleteById(Long id) {
        this.clientData.deleteById(id);
    }
}
