package funerary.genro.feliz.infra.database.impl;

import funerary.genro.feliz.app.repositories.SellerRepository;
import funerary.genro.feliz.domain.Seller;
import funerary.genro.feliz.infra.database.SellerData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SellerRepositoryImpl implements SellerRepository {

    private final SellerData sellerData;

    public SellerRepositoryImpl(SellerData sellerData){
        this.sellerData = sellerData;
    }


    @Override
    public List<Seller> findAll() {
        return this.sellerData.findAll();
    }

    @Override
    public Optional<Seller> findById(Long id) {
        return this.sellerData.findById(id);
    }

    @Override
    public void save(Seller newSeller) {
        this.sellerData.save(newSeller);
    }

    @Override
    public void deleteById(Long id) {
        this.sellerData.deleteById(id);
    }
}
