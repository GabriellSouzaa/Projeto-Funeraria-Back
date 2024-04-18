package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.Client;

import java.util.List;
import java.util.Optional;

public interface IClientRepository {

    List<Client> findAll();

    Optional<Client> findById(Long id);


}
