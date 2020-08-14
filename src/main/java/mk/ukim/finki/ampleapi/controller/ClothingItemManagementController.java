package mk.ukim.finki.ampleapi.controller;

import mk.ukim.finki.ampleapi.domain.ClothingItem;
import mk.ukim.finki.ampleapi.domain.dto.ClothingItemDto;
import mk.ukim.finki.ampleapi.domain.exceptions.StorageException;
import mk.ukim.finki.ampleapi.service.ClothingItemManagementService;
import mk.ukim.finki.ampleapi.service.ImageStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/item/post")
    public ResponseEntity<ClothingItem> shareClothingItem(@RequestBody ClothingItemDto item){
        return clothingItemManagementService.shareClothingItem(
                new ClothingItem(item.getName(), item.getDescription(), item.getCategory(), item.getSize(), item.getPrice(), item.getPhoto())
        ).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
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
}
