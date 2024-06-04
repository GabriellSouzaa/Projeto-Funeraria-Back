package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeneficiaryData extends JpaRepository<Beneficiary, Long> {

    List<Beneficiary> findAllByClient(Client client);

    List<Beneficiary> findAllByAtivo(String ativo);
}
