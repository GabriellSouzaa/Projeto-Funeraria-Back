package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.Coffin;

import java.util.List;
import java.util.Optional;

public interface CoffinRepository {

    List<Coffin> findAll();

    Optional<Coffin> findById(Long id);

    void save(Coffin newCoffin);

    void deleteById(Long id);
}
