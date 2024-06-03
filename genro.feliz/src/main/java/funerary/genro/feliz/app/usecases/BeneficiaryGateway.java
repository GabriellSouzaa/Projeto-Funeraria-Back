package funerary.genro.feliz.app.usecases;

import funerary.genro.feliz.app.models.requests.BeneficiaryRequest;
import funerary.genro.feliz.app.models.requests.CoffinRequest;
import funerary.genro.feliz.app.models.responses.BeneficiaryResponse;
import funerary.genro.feliz.app.models.responses.CoffinResponse;
import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.domain.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BeneficiaryGateway {

    List<BeneficiaryResponse> getBeneficiarys();

    List<BeneficiaryResponse> getBeneficiariesOfClient(Long id);

    ResponseEntity<byte[]> getBeneficiariesOfClientReport(Long id);

    BeneficiaryResponse getBeneficiary(Long id);

    void createBeneficiary(BeneficiaryRequest beneficiaryRequest);

    void updateBeneficiary(Long id, BeneficiaryRequest beneficiaryRequest);

    void deleteBeneficiary(Long id);
}
