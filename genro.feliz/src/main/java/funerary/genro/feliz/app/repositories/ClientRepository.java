package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> findAll();

    List<Client> findAllByAtivo(String ativo);

    Optional<Client> findById(Long id);

    Optional<Client> findByNome(String nome);

    void save(Client newClient);
    void deleteById(Long id);



}
