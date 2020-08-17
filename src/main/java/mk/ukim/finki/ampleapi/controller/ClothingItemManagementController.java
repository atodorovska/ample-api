package mk.ukim.finki.ampleapi.controller;

import mk.ukim.finki.ampleapi.domain.ClothingItem;
import mk.ukim.finki.ampleapi.domain.dto.GetClothingItemDto;
import mk.ukim.finki.ampleapi.domain.dto.PaginationDto;
import mk.ukim.finki.ampleapi.domain.dto.ShareClothingItemDto;
import mk.ukim.finki.ampleapi.domain.exceptions.StorageException;
import mk.ukim.finki.ampleapi.service.ClothingItemManagementService;
import mk.ukim.finki.ampleapi.service.ImageStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/clothing")
public class ClothingItemManagementController {

    private final ClothingItemManagementService clothingItemManagementService;
    private final ImageStorageService imageStorageService;

    public ClothingItemManagementController(ClothingItemManagementService clothingItemManagementService, ImageStorageService imageStorageService) {
        this.clothingItemManagementService = clothingItemManagementService;
        this.imageStorageService = imageStorageService;
    }

    @GetMapping("/item/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws FileNotFoundException {

        Resource file = imageStorageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/file")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws StorageException {
        imageStorageService.store(file);
    }

    @PostMapping("/item/share")
    public void shareClothingItem(@RequestBody ShareClothingItemDto item){
        clothingItemManagementService.shareClothingItem(item);
    }

    @PostMapping("/item/get")
    public void getClothingItem(@RequestBody GetClothingItemDto item){
        clothingItemManagementService.getClothingItem(item);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothingItem> findClothingItem(@PathVariable Long id){
        return clothingItemManagementService.findClothingItem(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/latest")
    public ResponseEntity<List<ClothingItem>> latestClothingItems() {
        return this.clothingItemManagementService.latestClothingItems(12).map(u -> ResponseEntity.ok().body(u))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/all")
    public ResponseEntity<List<ClothingItem>> allClothingItems(@RequestBody PaginationDto paginationDto) {
        return this.clothingItemManagementService.allClothingItems(paginationDto).map(u -> ResponseEntity.ok().body(u))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
