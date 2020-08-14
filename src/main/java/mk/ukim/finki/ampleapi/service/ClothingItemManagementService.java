package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.ClothingItem;

import java.util.List;
import java.util.Optional;

public interface ClothingItemManagementService {
    Optional<List<ClothingItem>> latestClothingItems(Integer quantity);

    Optional<ClothingItem> shareClothingItem(ClothingItem item);

    Optional<ClothingItem> findClothingItem(Long item);
}
