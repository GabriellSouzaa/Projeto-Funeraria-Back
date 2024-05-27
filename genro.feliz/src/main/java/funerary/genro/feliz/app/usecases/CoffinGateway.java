package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.ClientRequest;
import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.domain.Coffin;

import java.util.List;

public interface CoffinGateway {

    List<CoffinResponse> getCoffins();
    CoffinResponse getCoffin(Long id);

    void createCoffin(CoffinRequest coffinRequest);

    void updateCoffin(Long id, CoffinRequest coffinRequest);

    void deleteCoffin(Long id);
}
