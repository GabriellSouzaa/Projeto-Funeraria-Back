package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.FuneralParlorUsages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuneralParlorUsagesData extends JpaRepository<FuneralParlorUsages, Long> {
}
