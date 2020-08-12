package mk.ukim.finki.ampleapi.domain.dto;

import mk.ukim.finki.ampleapi.domain.ItemCategory;
import mk.ukim.finki.ampleapi.domain.ItemSize;

public class ClothingItemDto {

    private String name;

    private String description;

    private ItemCategory category;

    private ItemSize size;

    private Integer price;

    private String photo;


    public ClothingItemDto(String name, String description, ItemCategory category, ItemSize size, Integer price, String photo) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.size = size;
        this.price = price;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public ItemSize getSize() {
        return size;
    }

    public void setSize(ItemSize size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
