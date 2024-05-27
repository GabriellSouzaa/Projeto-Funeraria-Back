package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.FuneralParlor;

import java.util.List;
import java.util.Optional;

public interface FuneralParlorRepository {

    List<FuneralParlor> findAll();

    Optional<FuneralParlor> findById(Long id);

    void save(FuneralParlor funeralParlor);

    void deleteById(Long id);
}
