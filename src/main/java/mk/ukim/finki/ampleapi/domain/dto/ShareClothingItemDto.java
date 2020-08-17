package mk.ukim.finki.ampleapi.domain.dto;

import mk.ukim.finki.ampleapi.domain.ItemCategory;
import mk.ukim.finki.ampleapi.domain.ItemSize;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShareClothingItemDto {

    private String name;

    private String description;

    private ItemCategory category;

    private ItemSize size;

    private Integer price;

    private String photo;

    private String address;

    private Date date;

    private String number;

    private String username;

    public ShareClothingItemDto() {
    }

    public ShareClothingItemDto(String name, String description, ItemCategory category, ItemSize size, Integer price, String photo,
                                String address, String date, String number, String username) throws ParseException {
        this.name = name;
        this.description = description;
        this.category = category;
        this.size = size;
        this.price = price;
        this.photo = photo;
        this.address = address;
        this.date = new SimpleDateFormat("dd/mm/yyyy").parse(date);
        this.number = number;
        this.username = username;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ShareItemDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", size=" + size +
                ", price=" + price +
                ", photo='" + photo + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
