package funerary.genro.feliz.infra.database.impl;


import funerary.genro.feliz.app.repositories.FuneralPlanRepository;
import funerary.genro.feliz.domain.FuneralPlan;
import funerary.genro.feliz.infra.database.FuneralPlanData;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class FuneralPlanRepositoryImpl implements FuneralPlanRepository {

    private final FuneralPlanData funeralPlanData;

    public FuneralPlanRepositoryImpl(FuneralPlanData funeralPlanData){
        this.funeralPlanData = funeralPlanData;
    }
    @Override
    public List<FuneralPlan> findAll() {
      return this.funeralPlanData.findAll();
    }

    @Override
    public List<FuneralPlan> findDelayedFuneralPlans(String pagoEsseMes, LocalDate dataAtual) {
        return this.funeralPlanData.findByPagoEsseMesAndDataPagamentoBefore(pagoEsseMes, dataAtual);
    }

    @Override
    public Optional<FuneralPlan> findById(Long id) {
        return this.funeralPlanData.findById(id);
    }

    @Override
    public void save(FuneralPlan funeralPlan) {
        this.funeralPlanData.save(funeralPlan);
    }

    @Override
    public void deleteById(Long id) {
         this.funeralPlanData.deleteById(id);
    }
}
