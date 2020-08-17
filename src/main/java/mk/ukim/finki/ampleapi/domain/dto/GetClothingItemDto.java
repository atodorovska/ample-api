package mk.ukim.finki.ampleapi.domain.dto;

import java.util.Date;

public class GetClothingItemDto {

    private String address;

    private Date date;

    private String number;

    private String username;

    private Long item;

    public GetClothingItemDto(String address, Date date, String number, String username, Long item) {
        this.address = address;
        this.date = date;
        this.number = number;
        this.username = username;
        this.item = item;
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

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "GetClothingItemDto{" +
                "address='" + address + '\'' +
                ", date=" + date +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                ", item=" + item +
                '}';
    }
}
