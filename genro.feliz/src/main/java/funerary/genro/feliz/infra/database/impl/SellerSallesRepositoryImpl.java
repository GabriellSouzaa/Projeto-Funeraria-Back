package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.SellerSallesRepository;
import funerary.genro.feliz.domain.Seller;
import funerary.genro.feliz.domain.SellerSalles;
import funerary.genro.feliz.infra.database.SellerData;
import funerary.genro.feliz.infra.database.SellerSallesData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SellerSallesRepositoryImpl implements SellerSallesRepository {

    private final SellerSallesData sellerData;

    public SellerSallesRepositoryImpl(SellerSallesData sellerData){
        this.sellerData = sellerData;
    }


    @Override
    public List<SellerSalles> findAll() {
        return this.sellerData.findAll();
    }

    @Override
    public Optional<SellerSalles> findById(Long id) {
        return this.sellerData.findById(id);
    }

    @Override
    public void save(SellerSalles newSeller) {
        this.sellerData.save(newSeller);
    }

    @Override
    public void deleteById(Long id) {
        this.sellerData.deleteById(id);
    }
}
