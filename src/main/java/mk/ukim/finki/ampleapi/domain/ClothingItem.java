package mk.ukim.finki.ampleapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "clothing_item")
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private ItemCategory category;

    @Enumerated(EnumType.STRING)
    private ItemSize size;

    private Integer price;

    private String photo;

    private Boolean taken;

    public ClothingItem() {
    }

    public ClothingItem(String name, String description, ItemCategory category, ItemSize size, Integer price, String photo, Boolean taken) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.size = size;
        this.price = price;
        this.photo = photo;
        this.taken = taken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    @Override
    public String toString() {
        return "ClothingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", size=" + size +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", taken=" + taken +
                '}';
    }
}
