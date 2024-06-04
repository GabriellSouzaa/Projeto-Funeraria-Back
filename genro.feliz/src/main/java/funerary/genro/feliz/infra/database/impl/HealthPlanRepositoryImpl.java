package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.HealthPlanRepository;
import funerary.genro.feliz.domain.HealthPlan;
import funerary.genro.feliz.infra.database.HealthPlanData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthPlanRepositoryImpl implements HealthPlanRepository {

    private final HealthPlanData healthPlanData;

    public HealthPlanRepositoryImpl(HealthPlanData healthPlanData){
        this.healthPlanData = healthPlanData;
    }


    @Override
    public List<HealthPlan> findAll() {
        return this.healthPlanData.findAll();
    }

    @Override
    public Optional<HealthPlan> findById(Long id) {
        return this.healthPlanData.findById(id);
    }

    @Override
    public void save(HealthPlan newHealthPlan) {
        this.healthPlanData.save(newHealthPlan);
    }

    @Override
    public void deleteById(Long id) {
        this.healthPlanData.deleteById(id);
    }
}
