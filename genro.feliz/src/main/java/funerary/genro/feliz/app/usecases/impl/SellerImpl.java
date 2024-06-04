package funerary.genro.feliz.app.usecases.impl;

import funerary.genro.feliz.app.exception.custom.ClientNotFoundException;
import funerary.genro.feliz.app.models.requests.SellerRequest;
import funerary.genro.feliz.app.models.responses.CoffinSalesResponse;
import funerary.genro.feliz.app.models.responses.FuneralParlorResponse;
import funerary.genro.feliz.app.models.responses.SellerResponse;
import funerary.genro.feliz.app.repositories.SellerRepository;
import funerary.genro.feliz.app.usecases.SellerGateway;
import funerary.genro.feliz.domain.Coffin;
import funerary.genro.feliz.domain.FuneralParlor;
import funerary.genro.feliz.domain.Seller;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SellerImpl implements SellerGateway {

    private final SellerRepository sellerRepository;

    public SellerImpl(SellerRepository sellerRepository){
        this.sellerRepository = sellerRepository;
    }

    @Override
    public List<SellerResponse> getSellers() {
        List<Seller> responses = this.sellerRepository.findAll();
        return responses.stream().map(SellerResponse::from).collect(Collectors.toList());
    }

    @Override
    public SellerResponse getSeller(Long id) {
        Optional<Seller> optionalSeller = this.sellerRepository.findById(id);
        Seller seller;
        if (optionalSeller.isEmpty()) {
            throw new ClientNotFoundException("Vendedor não Encontrado!");
        } else {
            seller = optionalSeller.get();
        }
        return SellerResponse.from(seller);
    }

    @Override
    public void createSeller(SellerRequest sellerRequest) {
        Seller newSeller = new Seller();
        newSeller.setCargo(sellerRequest.getCargo());
        newSeller.setNome(sellerRequest.getNome());
        this.sellerRepository.save(newSeller);
    }

    @Override
    public void updateSeller(Long id, SellerRequest sellerRequest) {
        Optional<Seller> optionalSeller = this.sellerRepository.findById(id);
        Seller seller;
        if (optionalSeller.isEmpty()) {
            throw new ClientNotFoundException("Vendedor não Encontrado!");
        } else {
            seller = optionalSeller.get();
            seller.setCargo(sellerRequest.getCargo());
            seller.setNome(sellerRequest.getNome());
            this.sellerRepository.save(seller);
        }
    }

    @Override
    public void deleteSeller(Long id) {
        Optional<Seller> optionalSeller = this.sellerRepository.findById(id);
        Seller seller;
        if (optionalSeller.isEmpty()) {
            throw new ClientNotFoundException("Vendedor não Encontrado!");
        } else {
            seller = optionalSeller.get();
            this.sellerRepository.deleteById(seller.getId());
        }
    }


}
