package mk.ukim.finki.ampleapi.domain.dto;

public class PaginationDto {

    private Integer current;

    private Integer items;

    public PaginationDto(Integer current, Integer items) {
        this.current = current;
        this.items = items;
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
        return "PaginationDto{" +
                "current=" + current +
                ", items=" + items +
                '}';
    }
}
