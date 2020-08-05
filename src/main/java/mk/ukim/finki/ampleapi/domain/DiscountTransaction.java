package mk.ukim.finki.ampleapi.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "discount_transaction")
public class DiscountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long discount;

    private Long person;

    private ZonedDateTime timestamp;

    private Date validity;

    public DiscountTransaction() {
    }

    public DiscountTransaction(Long discount, Long person, ZonedDateTime timestamp, Date validity) {
        this.discount = discount;
        this.person = person;
        this.timestamp = timestamp;
        this.validity = validity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    @Override
    public String toString() {
        return "DiscountTransaction{" +
                "id=" + id +
                ", discount=" + discount +
                ", person=" + person +
                ", timestamp=" + timestamp +
                ", validity=" + validity +
                '}';
    }
}
