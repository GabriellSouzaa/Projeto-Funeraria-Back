package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.CoffinRepository;
import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.infra.database.CoffinData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CoffinRepositoryImpl implements CoffinRepository {

    private final CoffinData coffinData;

    public CoffinRepositoryImpl(CoffinData coffinData){
        this.coffinData = coffinData;
    }
    @Override
    public List<Coffin> findAll() {
        return this.coffinData.findAll();
    }

    @Override
    public Optional<Coffin> findById(Long id) {
        return this.coffinData.findById(id);
    }

    @Override
    public void save(Coffin newCoffin) {
        this.coffinData.save(newCoffin);
    }

    @Override
    public void deleteById(Long id) {
        this.coffinData.deleteById(id);
    }
}
