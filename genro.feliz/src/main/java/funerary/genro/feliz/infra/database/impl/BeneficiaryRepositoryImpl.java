package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.BeneficiaryRepository;
import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.domain.Client;
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
    public List<Beneficiary> findAllByClient(Client client) {
        return this.beneficiaryData.findAllByClient(client);
    }

    @Override
    public List<Beneficiary> findAllByAtivoAndClient(String ativo, Client id) {
        return this.beneficiaryData.findAllByAtivoAndClient(ativo, id);
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
