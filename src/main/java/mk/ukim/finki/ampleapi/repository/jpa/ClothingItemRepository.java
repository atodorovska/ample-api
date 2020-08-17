package mk.ukim.finki.ampleapi.repository.jpa;

import mk.ukim.finki.ampleapi.domain.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {

}
