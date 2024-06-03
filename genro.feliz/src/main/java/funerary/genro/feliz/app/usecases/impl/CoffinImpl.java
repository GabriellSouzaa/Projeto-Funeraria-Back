package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.app.models.responses.CoffinSalesResponse;
import funerary.genro.feliz.app.repositories.CoffinRepository;
import funerary.genro.feliz.app.usecases.CoffinGateway;
import funerary.genro.feliz.domain.Coffin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoffinImpl implements CoffinGateway {

    private final CoffinRepository coffinRepository;

    public CoffinImpl(CoffinRepository coffinRepository){
        this.coffinRepository = coffinRepository;
    }

    @Override
    public List<CoffinResponse> getCoffins() {
        List<Coffin> coffins = this.coffinRepository.findAll();
        return coffins.stream().map(CoffinResponse::from).collect(Collectors.toList());
    }

    @Override
    public CoffinResponse getCoffin(Long id) {
        Optional<Coffin> optionalCoffin = this.coffinRepository.findById(id);
        Coffin coffin;
        if (optionalCoffin.isEmpty()) {
            throw new ClientNotFoundException("Caixão não Encontrado!");
        } else {
            coffin = optionalCoffin.get();
        }

        return CoffinResponse.from(coffin);
    }


    @Override
    public void createCoffin(CoffinRequest coffinRequest) {
        Coffin newCoffin = new Coffin();
        newCoffin.setMaterial(coffinRequest.getMaterial());
        newCoffin.setCor(coffinRequest.getCor());
        newCoffin.setComprimento(coffinRequest.getComprimento());
        newCoffin.setModelo(coffinRequest.getModelo());
        newCoffin.setPreco(coffinRequest.getPreco());
        this.coffinRepository.save(newCoffin);
            }

    @Override
    public void updateCoffin(Long id, CoffinRequest coffinRequest) {
        Optional<Coffin> optionalCoffin = this.coffinRepository.findById(id);

        if (optionalCoffin.isEmpty()) {
            throw new ClientNotFoundException("Caixão não Encontrado!");
        } else {
            Coffin coffin = optionalCoffin.get();
            coffin.setMaterial(coffinRequest.getMaterial());
            coffin.setCor(coffinRequest.getCor());
            coffin.setComprimento(coffinRequest.getComprimento());
            coffin.setModelo(coffinRequest.getModelo());
            coffin.setPreco(coffinRequest.getPreco());
            this.coffinRepository.save(coffin);
        }
    }

    @Override
    public void deleteCoffin(Long id) {
        Optional<Coffin> optionalCoffin = this.coffinRepository.findById(id);
        if (optionalCoffin.isEmpty()) {
            throw new ClientNotFoundException("Caixão não Encontrado!");
        } else {
            this.coffinRepository.deleteById(id);
        }
    }
}
