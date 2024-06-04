package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.FuneralParlorRepository;
import funerary.genro.feliz.app.repositories.FuneralParlorUsagesRepository;
import funerary.genro.feliz.domain.FuneralParlor;
import funerary.genro.feliz.domain.FuneralParlorUsages;
import funerary.genro.feliz.infra.database.FuneralParlorUsagesData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FuneralParlorUsagesRepositoryImpl implements FuneralParlorUsagesRepository {

    private final FuneralParlorUsagesData funeralParlorUsagesData;

    public FuneralParlorUsagesRepositoryImpl(FuneralParlorUsagesData funeralParlorUsagesData){
        this.funeralParlorUsagesData = funeralParlorUsagesData;
    }

    @Override
    public List<FuneralParlorUsages> findAll() {
        return this.funeralParlorUsagesData.findAll();
    }

    @Override
    public Optional<FuneralParlorUsages> findById(Long id) {
        return this.funeralParlorUsagesData.findById(id);
    }

    @Override
    public void save(FuneralParlorUsages funeralParlor) {
        this.funeralParlorUsagesData.save(funeralParlor);
    }

    @Override
    public void deleteById(Long id) {
        this.funeralParlorUsagesData.deleteById(id);
    }
}
