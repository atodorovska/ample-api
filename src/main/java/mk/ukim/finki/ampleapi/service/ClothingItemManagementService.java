package mk.ukim.finki.ampleapi.service;

import mk.ukim.finki.ampleapi.domain.ClothingItem;
import mk.ukim.finki.ampleapi.domain.dto.ClothingItemsDto;
import mk.ukim.finki.ampleapi.domain.dto.GetClothingItemDto;
import mk.ukim.finki.ampleapi.domain.dto.ShareClothingItemDto;

import java.util.List;
import java.util.Optional;

public interface ClothingItemManagementService {
    Optional<List<ClothingItem>> latestClothingItems(Integer quantity);

    void shareClothingItem(ShareClothingItemDto item);

    Optional<ClothingItem> findClothingItem(Long item);

    void getClothingItem(GetClothingItemDto item);

    Optional<List<ClothingItem>> allClothingItems(ClothingItemsDto clothingItemsDto);
}
