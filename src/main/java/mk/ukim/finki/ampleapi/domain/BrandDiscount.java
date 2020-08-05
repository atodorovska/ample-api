package mk.ukim.finki.ampleapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "brand_discount")
public class BrandDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String photo;

    private Integer discount;

    private String description;

    private Integer points;

    public BrandDiscount() {
    }

    public BrandDiscount(String name, String photo, Integer discount, String description, Integer points) {
        this.name = name;
        this.photo = photo;
        this.discount = discount;
        this.description = description;
        this.points = points;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "BrandDiscount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                ", points=" + points +
                '}';
    }
}
