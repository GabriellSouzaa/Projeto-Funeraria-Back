package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerData extends JpaRepository<Seller, Long> {
}
