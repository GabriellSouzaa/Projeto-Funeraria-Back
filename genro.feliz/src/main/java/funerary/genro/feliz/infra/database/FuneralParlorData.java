package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.FuneralParlor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuneralParlorData extends JpaRepository<FuneralParlor, Long> {
}
