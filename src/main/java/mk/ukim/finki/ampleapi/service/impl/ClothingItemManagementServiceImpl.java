package mk.ukim.finki.ampleapi.service.impl;

import mk.ukim.finki.ampleapi.domain.ClothingItem;
import mk.ukim.finki.ampleapi.repository.jpa.ClothingItemRepository;
import mk.ukim.finki.ampleapi.service.ClothingItemManagementService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClothingItemManagementServiceImpl implements ClothingItemManagementService {

    private final ClothingItemRepository clothingItemRepository;

    public ClothingItemManagementServiceImpl(ClothingItemRepository clothingItemRepository) {
        this.clothingItemRepository = clothingItemRepository;
    }

    @Override
    public Optional<List<ClothingItem>> latestClothingItems(Integer quantity){
        List<ClothingItem> list = this.clothingItemRepository.findAll();
        Collections.reverse(list);
        return Optional.of(list.subList(0, quantity));
    }

    @Override
    public Optional<ClothingItem> shareClothingItem(ClothingItem item) {
        clothingItemRepository.save(item);
        return Optional.of(item);
    }
}
