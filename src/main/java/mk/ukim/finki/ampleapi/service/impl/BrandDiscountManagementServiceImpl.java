package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.domain.BrandDiscount;
import mk.ukim.finki.ampleapi.repository.jpa.BrandDiscountRepository;
import mk.ukim.finki.ampleapi.service.BrandDiscountManagementService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BrandDiscountManagementServiceImpl implements BrandDiscountManagementService {

    private final BrandDiscountRepository brandDiscountRepository;

    public BrandDiscountManagementServiceImpl(BrandDiscountRepository brandDiscountRepository) {
        this.brandDiscountRepository = brandDiscountRepository;
    }

    @Override
    public Optional<List<BrandDiscount>> latestDiscounts(Integer quantity){
        List<BrandDiscount> list = this.brandDiscountRepository.findAll();
        Collections.reverse(list);
        return Optional.of(list.subList(0, quantity));
    }

    @Override
    public Optional<BrandDiscount> findClothingItem(Long id) {
        return this.brandDiscountRepository.findById(id);
    }
}
