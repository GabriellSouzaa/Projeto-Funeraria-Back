package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.CoffinRepository;
import funerary.genro.feliz.app.repositories.CoffinSalesRepository;
import funerary.genro.feliz.domain.CoffinSales;
import funerary.genro.feliz.infra.database.CoffinSalesData;
import funerary.genro.feliz.infra.database.FuneralPlanData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CoffinSalesRepositoryImpl implements CoffinSalesRepository {

    private final CoffinSalesData coffinSalesData;

    public CoffinSalesRepositoryImpl(CoffinSalesData coffinSalesData){
        this.coffinSalesData = coffinSalesData;
    }


    @Override
    public List<CoffinSales> findAll() {
        return this.coffinSalesData.findAll();
    }

    @Override
    public Optional<CoffinSales> findById(Long id) {
        return this.coffinSalesData.findById(id);
    }

    @Override
    public void save(CoffinSales newCoffinSales) {
        this.coffinSalesData.save(newCoffinSales);
    }

    @Override
    public void deleteById(Long id) {
        this.coffinSalesData.deleteById(id);
    }
}
