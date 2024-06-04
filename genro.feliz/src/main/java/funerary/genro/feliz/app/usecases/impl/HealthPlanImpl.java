package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.HealthPlanRequest;
import funerary.genro.feliz.app.models.responses.FuneralParlorResponse;
import funerary.genro.feliz.app.models.responses.HealthPlanResponse;
import funerary.genro.feliz.app.repositories.HealthPlanRepository;
import funerary.genro.feliz.app.usecases.HealthPlanGateway;
import funerary.genro.feliz.domain.FuneralParlor;
import funerary.genro.feliz.domain.HealthPlan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HealthPlanImpl implements HealthPlanGateway {

    private final HealthPlanRepository healthPlanRepository;

    public HealthPlanImpl(HealthPlanRepository healthPlanRepository){
        this.healthPlanRepository = healthPlanRepository;
    }

    @Override
    public List<HealthPlanResponse> getHealthPlans() {
        List<HealthPlan> healthPlans = this.healthPlanRepository.findAll();
        return healthPlans.stream().map(HealthPlanResponse::from).collect(Collectors.toList());
    }

    @Override
    public HealthPlanResponse getHealthPlan(Long id) {
        Optional<HealthPlan> optionalHealthPlan = this.healthPlanRepository.findById(id);
        HealthPlan healthPlan;
        if (optionalHealthPlan.isEmpty()) {
            throw new ClientNotFoundException("Plano de saude não Encontrado!");
        } else {
            healthPlan = optionalHealthPlan.get();
        }
        return HealthPlanResponse.from(healthPlan);
    }

    @Override
    public void updateHealthPlan(Long id, HealthPlanRequest healthPlanRequest) {
        Optional<HealthPlan> optionalHealthPlan = this.healthPlanRepository.findById(id);
        HealthPlan healthPlan;
        if (optionalHealthPlan.isEmpty()) {
            throw new ClientNotFoundException("Plano de saude não Encontrado!");
        } else {
            healthPlan = optionalHealthPlan.get();
            healthPlan.setTelefone(healthPlanRequest.getTelefone());
            healthPlan.setDescricao(healthPlanRequest.getDescricao());
            healthPlan.setValor(healthPlanRequest.getValor());
            this.healthPlanRepository.save(healthPlan);
        }

    }

    @Override
    public void createHealthPlan(HealthPlanRequest healthPlanRequest) {
        HealthPlan newHealthPlan = new HealthPlan();
        newHealthPlan.setTelefone(healthPlanRequest.getTelefone());
        newHealthPlan.setDescricao(healthPlanRequest.getDescricao());
        newHealthPlan.setValor(healthPlanRequest.getValor());
        this.healthPlanRepository.save(newHealthPlan);
    }

    @Override
    public void deleteHealthPlan(Long id) {
        Optional<HealthPlan> optionalHealthPlan = this.healthPlanRepository.findById(id);
        if (optionalHealthPlan.isEmpty()) {
            throw new ClientNotFoundException("Plano de saude não Encontrado!");
        } else {
            this.healthPlanRepository.deleteById(id);
        }
    }
}
