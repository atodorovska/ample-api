package mk.ukim.finki.ampleapi.controller;

import mk.ukim.finki.ampleapi.domain.BrandDiscount;
import mk.ukim.finki.ampleapi.domain.ClothingItem;
import mk.ukim.finki.ampleapi.service.BrandDiscountManagementService;
import mk.ukim.finki.ampleapi.service.ImageStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class BrandDiscountManagementController {

    private final BrandDiscountManagementService brandDiscountManagementService;
    private final ImageStorageService imageStorageService;

    public BrandDiscountManagementController(BrandDiscountManagementService brandDiscountManagementService, ImageStorageService imageStorageService) {
        this.brandDiscountManagementService = brandDiscountManagementService;
        this.imageStorageService = imageStorageService;
    }

    @GetMapping("/item/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws FileNotFoundException {

        Resource file = imageStorageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/latest")
    public ResponseEntity<List<BrandDiscount>> latestClothingItems() {
        return this.brandDiscountManagementService.latestDiscounts(12).map(u -> ResponseEntity.ok().body(u))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
