package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.BrandDiscount;

import java.util.List;
import java.util.Optional;

public interface BrandDiscountManagementService {
    Optional<List<BrandDiscount>> latestDiscounts(Integer quantity);

    Optional<BrandDiscount> findClothingItem(Long id);
}
