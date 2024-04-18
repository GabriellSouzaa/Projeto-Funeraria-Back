package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.IClientRepository;
import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.infra.database.ClientData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientRepository {

    private final ClientData clientData;

    public ClientRepository(ClientData clientData){ this.clientData = clientData;}
    @Override
    public List<Client> findAll() {
        return this.clientData.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return this.clientData.findById(id);
    }
}
