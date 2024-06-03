package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.CoffinSales;

import java.util.List;
import java.util.Optional;

public interface CoffinSalesRepository {

    List<CoffinSales> findAll();

    Optional<CoffinSales> findById(Long id);

    void save(CoffinSales newCoffinSales);

    void deleteById(Long id);
}
