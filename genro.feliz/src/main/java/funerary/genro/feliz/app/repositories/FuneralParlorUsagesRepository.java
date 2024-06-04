package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.FuneralParlor;
import funerary.genro.feliz.domain.FuneralParlorUsages;

import java.util.List;
import java.util.Optional;

public interface FuneralParlorUsagesRepository {

    List<FuneralParlorUsages> findAll();

    Optional<FuneralParlorUsages> findById(Long id);

    void save(FuneralParlorUsages funeralParlor);

    void deleteById(Long id);
}
