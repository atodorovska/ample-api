package mk.ukim.finki.ampleapi.repository.jpa;

import mk.ukim.finki.ampleapi.domain.ClothingItem;
import mk.ukim.finki.ampleapi.domain.ItemCategory;
import mk.ukim.finki.ampleapi.domain.ItemSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long>, JpaSpecificationExecutor<ClothingItem> {

    List<ClothingItem> findClothingItemsByCategory(ItemCategory category);
    List<ClothingItem> findClothingItemsBySize(ItemSize size);
    List<ClothingItem> findClothingItemsByCategoryAndSize(ItemCategory category, ItemSize size);
}