package mk.ukim.finki.ampleapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer points;

    private String address;

    public Person() {
    }

    public Person(Integer points) {
        this.points = points;
    }

    public Person(Integer points, String address) {
        this.points = points;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "domain.Person{" +
                "id=" + id +
                ", points=" + points +
                ", address='" + address + '\'' +
                '}';
    }
}

