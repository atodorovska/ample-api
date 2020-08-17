package mk.ukim.finki.ampleapi.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "discount_transaction")
public class DiscountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long discount;

    private Long person;

    private LocalDateTime timestamp;

    private String code;

    public DiscountTransaction() {
    }

    public DiscountTransaction(Long discount, Long person) {
        this.discount = discount;
        this.person = person;
        this.timestamp = LocalDateTime.now();
        this.code = UUID.randomUUID().toString();
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DiscountTransaction{" +
                "id=" + id +
                ", discount=" + discount +
                ", person=" + person +
                ", timestamp=" + timestamp +
                '}';
    }
}
