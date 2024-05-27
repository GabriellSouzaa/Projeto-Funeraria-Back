package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.BeneficiaryRepository;
import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.infra.database.BeneficiaryData;
import funerary.genro.feliz.infra.database.ClientData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BeneficiaryRepositoryImpl implements BeneficiaryRepository {

    private final BeneficiaryData beneficiaryData;

    public BeneficiaryRepositoryImpl(BeneficiaryData beneficiaryData){
        this.beneficiaryData = beneficiaryData;
    }

    @Override
    public List<Beneficiary> findAll() {
        return this.beneficiaryData.findAll();
    }

    @Override
    public Optional<Beneficiary> findById(Long id) {
        return this.beneficiaryData.findById(id);
    }

    @Override
    public void save(Beneficiary newBeneficiary) {
        this.beneficiaryData.save(newBeneficiary);
    }

    @Override
    public void deleteById(Long id) {
        this.beneficiaryData.deleteById(id);
    }
}
