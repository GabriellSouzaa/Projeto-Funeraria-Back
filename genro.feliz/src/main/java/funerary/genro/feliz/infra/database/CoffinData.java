package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.Coffin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffinData extends JpaRepository<Coffin, Long> {
}
