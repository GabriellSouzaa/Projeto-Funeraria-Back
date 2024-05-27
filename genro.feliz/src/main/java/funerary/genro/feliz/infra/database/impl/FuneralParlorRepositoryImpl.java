package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.FuneralParlorRepository;
import funerary.genro.feliz.app.repositories.FuneralPlanRepository;
import funerary.genro.feliz.domain.FuneralParlor;
import funerary.genro.feliz.domain.FuneralPlan;
import funerary.genro.feliz.infra.database.FuneralParlorData;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class FuneralParlorRepositoryImpl implements FuneralParlorRepository {


    private final FuneralParlorData funeralParlorData;

    public FuneralParlorRepositoryImpl(FuneralParlorData funeralParlorData){
        this.funeralParlorData = funeralParlorData;
    }

    @Override
    public List<FuneralParlor> findAll() {
        return this.funeralParlorData.findAll();
    }

    @Override
    public Optional<FuneralParlor> findById(Long id) {
        return this.funeralParlorData.findById(id);
    }

    @Override
    public void save(FuneralParlor funeralParlor) {
        this.funeralParlorData.save(funeralParlor);
    }

    @Override
    public void deleteById(Long id) {
        this.funeralParlorData.deleteById(id);
    }
}
