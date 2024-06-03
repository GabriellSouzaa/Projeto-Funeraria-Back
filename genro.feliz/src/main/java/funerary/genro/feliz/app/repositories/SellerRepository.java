package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerRepository {

    List<Seller> findAll();

    Optional<Seller> findById(Long id);

    void save(Seller newSeller);

    void deleteById(Long id);
}
