package mk.ukim.finki.ampleapi.repository.jpa;

import mk.ukim.finki.ampleapi.domain.BrandDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandDiscountRepository extends JpaRepository<BrandDiscount, Long> {

    List<BrandDiscount> findBrandDiscountsByNameLike(String name);
}
