package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.EmailRequest;
import funerary.genro.feliz.app.models.requests.FuneralPlanRequest;
import funerary.genro.feliz.app.models.responses.DelayedFuneralPlanResponse;
import funerary.genro.feliz.app.models.responses.FuneralPlanResponse;
import funerary.genro.feliz.app.repositories.ClientRepository;
import funerary.genro.feliz.app.repositories.FuneralPlanRepository;
import funerary.genro.feliz.app.usecases.FuneralPlanGateway;
import funerary.genro.feliz.domain.Client;
import funerary.genro.feliz.domain.FuneralPlan;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuneralPlanImpl implements FuneralPlanGateway {

    private final FuneralPlanRepository funeralPlanRepository;

    private final ClientRepository clientRepository;




    public FuneralPlanImpl(FuneralPlanRepository funeralPlanRepository, ClientRepository clientRepository){
        this.funeralPlanRepository = funeralPlanRepository;
        this.clientRepository = clientRepository;
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

    @Override
    public void updateFuneralPlan(Long id, FuneralPlanRequest funeralPlanRequest) {
        Optional<FuneralPlan> optionalFuneralPlan = this.funeralPlanRepository.findById(id);
        if (optionalFuneralPlan.isEmpty()) {
            throw new ClientNotFoundException("Plano Funeral não Encontrado");
        } else {
            FuneralPlan funeralPlan = optionalFuneralPlan.get();
            funeralPlan.setDataEnvio(LocalDateTime.now());
            funeralPlan.setValor(funeralPlanRequest.getValor());
            funeralPlan.setPagoEsseMes("Não");
            funeralPlan.setDataPagamento(funeralPlanRequest.getDataPagamento());
            funeralPlan.setDataPagamentoEfetuado(null);
            Optional<Client> client = this.clientRepository.findByNome(funeralPlanRequest.getNomeCliente());
            if (client.isEmpty()) {
                throw new ClientNotFoundException("Cliente não Encontrado");
            } else {
                funeralPlan.setClient(client.get());
            }
            this.funeralPlanRepository.save(funeralPlan);
        }

    }

    @Override
    public void createFuneralPlan(FuneralPlanRequest funeralPlanRequest) {
        FuneralPlan newFuneralPlan = new FuneralPlan();
        newFuneralPlan.setDataEnvio(LocalDateTime.now());
        newFuneralPlan.setValor(funeralPlanRequest.getValor());
        newFuneralPlan.setPagoEsseMes("Não");
        newFuneralPlan.setDataPagamento(funeralPlanRequest.getDataPagamento());
        newFuneralPlan.setDataPagamentoEfetuado(null);
        Optional<Client> client = this.clientRepository.findByNome(funeralPlanRequest.getNomeCliente());
        if (client.isEmpty()) {
            throw new ClientNotFoundException("Cliente não Encontrado");
        } else {
            newFuneralPlan.setClient(client.get());
        }
        this.funeralPlanRepository.save(newFuneralPlan);

    }

    @Override
    public void deleteFuneralPlan(Long id) {
        Optional<FuneralPlan> optionalFuneralPlan = this.funeralPlanRepository.findById(id);
        if (optionalFuneralPlan.isEmpty()) {
            throw new ClientNotFoundException("Plano Funeral não Encontrado");
        } else {
            this.funeralPlanRepository.deleteById(optionalFuneralPlan.get().getId());
        }
    }
         }

