package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.CoffinSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffinSalesData extends JpaRepository<CoffinSales, Long> {
}
