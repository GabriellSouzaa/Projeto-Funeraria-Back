package funerary.genro.feliz.app.usecases.impl;


import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.FuneralParlorRequest;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.app.models.responses.FuneralParlorResponse;
import funerary.genro.feliz.app.repositories.FuneralParlorRepository;
import funerary.genro.feliz.app.usecases.FuneralParlorGateway;
import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.FuneralParlor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuneralParlorImpl implements FuneralParlorGateway {

    private final FuneralParlorRepository funeralParlorRepository;

    private FuneralParlorImpl(FuneralParlorRepository funeralParlorRepository){
        this.funeralParlorRepository = funeralParlorRepository;
    }

    @Override
    public List<FuneralParlorResponse> getFuneralParlors() {
        List<FuneralParlor> funeralParlors = this.funeralParlorRepository.findAll();
        return funeralParlors.stream().map(FuneralParlorResponse::from).collect(Collectors.toList());
    }

    @Override
    public FuneralParlorResponse getFuneralParlor(Long id) {
        Optional<FuneralParlor> optionalFuneralParlor = this.funeralParlorRepository.findById(id);
        FuneralParlor funeralParlor;
        if (optionalFuneralParlor.isEmpty()) {
            throw new ClientNotFoundException("Sala de Velório não Encontrada!");
        } else {
            funeralParlor = optionalFuneralParlor.get();
        }

        return FuneralParlorResponse.from(funeralParlor);
    }

    @Override
    public void updateFuneralParlor(Long id, FuneralParlorRequest funeralParlorRequest) {
        Optional<FuneralParlor> optionalFuneralParlor = this.funeralParlorRepository.findById(id);
        FuneralParlor funeralParlor;
        if (optionalFuneralParlor.isEmpty()) {
            throw new ClientNotFoundException("Sala de Velório não Encontrada!");
        } else {
            funeralParlor = optionalFuneralParlor.get();
            funeralParlor.setDescricao(funeralParlorRequest.getDescricao());
            funeralParlor.setValor(funeralParlorRequest.getValor());
            this.funeralParlorRepository.save(funeralParlor);
        }
    }

    @Override
    public void createFuneralParlor(FuneralParlorRequest funeralParlorRequest) {
        FuneralParlor newFuneralParlor = new FuneralParlor();
        newFuneralParlor.setDescricao(funeralParlorRequest.getDescricao());
        newFuneralParlor.setValor(funeralParlorRequest.getValor());
        this.funeralParlorRepository.save(newFuneralParlor);
    }

    @Override
    public void deleteFuneralParlor(Long id) {
        Optional<FuneralParlor> optionalFuneralParlor = this.funeralParlorRepository.findById(id);
        FuneralParlor funeralParlor;
        if (optionalFuneralParlor.isEmpty()) {
            throw new ClientNotFoundException("Sala de Velório não Encontrada!");
        } else {
            funeralParlor = optionalFuneralParlor.get();
            this.funeralParlorRepository.save(funeralParlor);
           }
        }


    }

