package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.BrandDiscount;
import mk.ukim.finki.ampleapi.domain.DiscountTransaction;
import mk.ukim.finki.ampleapi.domain.dto.DiscountTransactionDto;
import mk.ukim.finki.ampleapi.domain.dto.DiscountsDto;

import java.util.List;
import java.util.Optional;

public interface BrandDiscountManagementService {
    Optional<List<BrandDiscount>> latestDiscounts(Integer quantity);

    Optional<BrandDiscount> findClothingItem(Long id);

    Optional<Integer> calculatePersonPoints(String username);

    Optional<String> createDiscountTransaction(DiscountTransactionDto discountTransactionDto);

    Optional<List<BrandDiscount>> allDiscounts(DiscountsDto discountsDto);
}
