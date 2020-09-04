package mk.ukim.finki.ampleapi.domain.dto;

public class ClothingItemsDto {

    private String category;

    private String size;

    private Integer current;

    private Integer items;

    public ClothingItemsDto() { }

    public ClothingItemsDto(String category, String size, Integer current, Integer items) {
        this.category = category;
        this.size = size;
        this.current = current;
        this.items = items;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ClothingItemsDto{" +
                "category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", current=" + current +
                ", items=" + items +
                '}';
    }
}
