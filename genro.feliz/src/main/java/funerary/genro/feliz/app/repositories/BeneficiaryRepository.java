package funerary.genro.feliz.app.repositories;

import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.domain.Client;

import java.util.List;
import java.util.Optional;

public interface BeneficiaryRepository {

    List<Beneficiary> findAll();

    List<Beneficiary> findAllByClient(Client client);

    List<Beneficiary> findAllByAtivoAndClient(String ativo, Client id);

    Optional<Beneficiary> findById(Long id);

    void save(Beneficiary newBeneficiary);

    void deleteById(Long id);
}
