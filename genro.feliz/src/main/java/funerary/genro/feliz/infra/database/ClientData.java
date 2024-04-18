package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientData extends JpaRepository<Client, Long> {

}
