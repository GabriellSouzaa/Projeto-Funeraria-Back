package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.requests.CoffinSalesRequest;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.app.models.responses.CoffinSalesResponse;
import funerary.genro.feliz.app.repositories.CoffinRepository;
import funerary.genro.feliz.app.repositories.CoffinSalesRepository;
import funerary.genro.feliz.app.usecases.CoffinSalesGateway;
import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.CoffinSales;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoffinSalesImpl implements CoffinSalesGateway {


    private final CoffinSalesRepository coffinSalesRepository;

    public CoffinSalesImpl(CoffinSalesRepository coffinSalesRepository){
        this.coffinSalesRepository = coffinSalesRepository;
    }

    @Override
    public List<CoffinSalesResponse> getCoffinsSales() {
        List<CoffinSales> coffinSales = this.coffinSalesRepository.findAll();
        return coffinSales.stream().map(CoffinSalesResponse::from).collect(Collectors.toList());
    }

    @Override
    public CoffinSalesResponse getCoffinSales(Long id) {
        Optional<CoffinSales> optionalCoffinSales = this.coffinSalesRepository.findById(id);
        CoffinSales coffinSales;
        if (optionalCoffinSales.isEmpty()) {
            throw new ClientNotFoundException("Venda de Caixão não Encontrado!");
        } else {
            coffinSales = optionalCoffinSales.get();
        }

        return CoffinSalesResponse.from(coffinSales);
    }


    @Override
    public void createCoffinSales(CoffinSalesRequest coffinSalesRequest) {
        CoffinSales newCoffinSales = new CoffinSales();
        newCoffinSales.setCoffin(coffinSalesRequest.getCoffin());
        newCoffinSales.setSeller(coffinSalesRequest.getSeller());
        newCoffinSales.setDataVenda(coffinSalesRequest.getDataVenda());
        this.coffinSalesRepository.save(newCoffinSales);
    }

    @Override
    public void updateCoffinSales(Long id, CoffinSalesRequest coffinSalesRequest) {
        Optional<CoffinSales> optionalCoffinSales = this.coffinSalesRepository.findById(id);

        if (optionalCoffinSales.isEmpty()) {
            throw new ClientNotFoundException("Venda de Caixão não Encontrada!");
        } else {
            CoffinSales coffinSales = optionalCoffinSales.get();
            coffinSales.setCoffin(coffinSalesRequest.getCoffin());
            coffinSales.setSeller(coffinSalesRequest.getSeller());
            coffinSales.setDataVenda(coffinSalesRequest.getDataVenda());
            this.coffinSalesRepository.save(coffinSales);
        }
    }

    @Override
    public void deleteCoffinSales(Long id) {
        Optional<CoffinSales> optionalCoffinSales = this.coffinSalesRepository.findById(id);
        if (optionalCoffinSales.isEmpty()) {
            throw new ClientNotFoundException("Venda de Caixão não Encontrado!");
        } else {
            this.coffinSalesRepository.deleteById(id);
        }
    }
}
