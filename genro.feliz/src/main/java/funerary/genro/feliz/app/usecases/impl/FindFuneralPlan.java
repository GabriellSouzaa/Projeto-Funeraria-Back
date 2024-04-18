package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;
import funerary.genro.feliz.app.repositories.IClientRepository;
import funerary.genro.feliz.app.repositories.IFuneralPlanRepository;
import funerary.genro.feliz.app.usecases.IFindFuneralPlan;
import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.FuneralPlan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindFuneralPlan implements IFindFuneralPlan {

    private final IFuneralPlanRepository funeralPlanRepository;


    public FindFuneralPlan(IFuneralPlanRepository funeralPlanRepository){
        this.funeralPlanRepository = funeralPlanRepository;

    }
    @Override
    public List<FuneralPlanResponse> getFuneralPlans() {
        List<FuneralPlan> funeralPlans = this.funeralPlanRepository.findAll();
        return funeralPlans.stream().map(FuneralPlanResponse::from).collect(Collectors.toList());
    }

    @Override
    public List<DelayedFuneralPlanResponse> getDelayedFuneralPlans() {
        List<FuneralPlan> funeralPlans = this.funeralPlanRepository.findDelayedFuneralPlans("N", LocalDate.now());
        return funeralPlans.stream().map(DelayedFuneralPlanResponse::from).collect(Collectors.toList());
    }
}
