package mk.ukim.finki.ampleapi.domain.dto;

import javax.lang.model.element.Name;

public class DiscountsDto {

    private String name;

    private Integer current;

    private Integer items;

    public DiscountsDto() {
    }

    public DiscountsDto(String name, Integer current, Integer items) {
        this.name = name;
        this.current = current;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "DiscountsDto{" +
                "name=" + name +
                ", current=" + current +
                ", items=" + items +
                '}';
    }
}
