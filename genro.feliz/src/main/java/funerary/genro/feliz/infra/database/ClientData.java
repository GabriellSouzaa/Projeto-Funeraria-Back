package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientData extends JpaRepository<Client, Long> {

    Optional<Client> findByNome(String nome);
}
