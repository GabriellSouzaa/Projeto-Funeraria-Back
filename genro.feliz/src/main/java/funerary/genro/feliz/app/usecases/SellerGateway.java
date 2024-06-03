package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.requests.SellerRequest;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.app.models.responses.SellerResponse;

import java.util.List;

public interface SellerGateway {

    List<SellerResponse> getSellers();

    SellerResponse getSeller(Long id);

    void createSeller(SellerRequest sellerRequest);

    void updateSeller(Long id, SellerRequest sellerRequest);

    void deleteSeller(Long id);
}
