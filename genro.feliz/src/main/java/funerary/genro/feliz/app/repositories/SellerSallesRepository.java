package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.Seller;
import funerary.genro.feliz.domain.SellerSalles;

import java.util.List;
import java.util.Optional;

public interface SellerSallesRepository {

    List<SellerSalles> findAll();

    Optional<SellerSalles> findById(Long id);

    void save(SellerSalles newSellerSalles);

    void deleteById(Long id);
}
