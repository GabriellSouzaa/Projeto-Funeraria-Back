package funerary.genro.feliz.infra.database.impl;


import funerary.genro.feliz.app.repositories.IFuneralPlanRepository;
import funerary.genro.feliz.domain.FuneralPlan;
import funerary.genro.feliz.infra.database.FuneralPlanData;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FuneralPlanRepository implements IFuneralPlanRepository {

    private final FuneralPlanData funeralPlanData;

    public FuneralPlanRepository(FuneralPlanData funeralPlanData){
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
}
