package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.SellerSalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SellerSallesData extends JpaRepository<SellerSalles, Long> {
}
