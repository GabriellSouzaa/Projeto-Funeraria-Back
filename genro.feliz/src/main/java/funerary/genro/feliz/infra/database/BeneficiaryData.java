package funerary.genro.feliz.infra.database;

import funerary.genro.feliz.domain.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryData extends JpaRepository<Beneficiary, Long> {
}
