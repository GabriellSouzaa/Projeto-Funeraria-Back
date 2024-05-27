package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.BeneficiaryRequest;
import funerary.genro.feliz.app.models.responses.BeneficiaryResponse;
import funerary.genro.feliz.app.models.responses.ClientResponse;
import funerary.genro.feliz.app.repositories.BeneficiaryRepository;
import funerary.genro.feliz.app.repositories.ClientRepository;
import funerary.genro.feliz.app.usecases.BeneficiaryGateway;
import funerary.genro.feliz.domain.Beneficiary;
import funerary.genro.feliz.domain.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeneficiaryImpl implements BeneficiaryGateway {

    private final ClientRepository clientRepository;

    private final BeneficiaryRepository beneficiaryRepository;

    public BeneficiaryImpl(BeneficiaryRepository beneficiaryRepository, ClientRepository clientRepository){
        this.beneficiaryRepository = beneficiaryRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<BeneficiaryResponse> getBeneficiarys() {
        List<Beneficiary> beneficiaries = this.beneficiaryRepository.findAll();
        return beneficiaries.stream().map(BeneficiaryResponse::from).collect(Collectors.toList());
    }

    @Override
    public List<BeneficiaryResponse> getBeneficiariesOfClient(Long id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        Client client;
        if (optionalClient.isEmpty()) {
            throw new ClientNotFoundException("Cliente não Encontrado");
        } else {
            client = optionalClient.get();
        }
        List<Beneficiary> beneficiaries = this.beneficiaryRepository.findAllByClient(client);
        return beneficiaries.stream().map(BeneficiaryResponse::from).collect(Collectors.toList());
    }

    @Override
    public BeneficiaryResponse getBeneficiary(Long id) {
        Optional<Beneficiary> optionalBeneficiary = this.beneficiaryRepository.findById(id);
        Beneficiary beneficiary;
        if (optionalBeneficiary.isEmpty()) {
            throw new ClientNotFoundException("Beneficiário não Encontrado");
        } else {
            beneficiary = optionalBeneficiary.get();
        }

        return BeneficiaryResponse.from(beneficiary);
    }

    @Override
    public void createBeneficiary(BeneficiaryRequest beneficiaryRequest) {
        Beneficiary newBeneficiary = new Beneficiary();
        newBeneficiary.setNome(beneficiaryRequest.getNome());
        newBeneficiary.setDataNascimento(beneficiaryRequest.getDataNascimento());
        newBeneficiary.setClient(beneficiaryRequest.getClient());
        newBeneficiary.setAdicional(beneficiaryRequest.getAdicional());
        this.beneficiaryRepository.save(newBeneficiary);
    }

    @Override
    public void updateBeneficiary(Long id, BeneficiaryRequest beneficiaryRequest) {
        Optional<Beneficiary> optionalBeneficiary = this.beneficiaryRepository.findById(id);
        Beneficiary beneficiary;
        if (optionalBeneficiary.isEmpty()) {
            throw new ClientNotFoundException("Beneficiário não Encontrado");
        } else {
            beneficiary = optionalBeneficiary.get();
            beneficiary.setNome(beneficiaryRequest.getNome());
            beneficiary.setDataNascimento(beneficiaryRequest.getDataNascimento());
            beneficiary.setClient(beneficiaryRequest.getClient());
            beneficiary.setAdicional(beneficiaryRequest.getAdicional());
            this.beneficiaryRepository.save(beneficiary);
        }

    }

    @Override
    public void deleteBeneficiary(Long id) {
        Optional<Beneficiary> optionalBeneficiary = this.beneficiaryRepository.findById(id);
        Beneficiary beneficiary;
        if (optionalBeneficiary.isEmpty()) {
            throw new ClientNotFoundException("Beneficiário não Encontrado");
        } else {
            beneficiary = optionalBeneficiary.get();
            this.beneficiaryRepository.deleteById(beneficiary.getId());
        }
    }
}
