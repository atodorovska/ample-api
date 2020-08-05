package mk.ukim.finki.ampleapi.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "share_transaction")
public class ShareTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long person;

    private Long item;

    private ZonedDateTime delivery;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Boolean success;

    public ShareTransaction() {
    }

    public ShareTransaction(Long person, Long item, ZonedDateTime delivery, TransactionType type, Boolean success) {
        this.person = person;
        this.item = item;
        this.delivery = delivery;
        this.type = type;
        this.success = success;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public ZonedDateTime getDelivery() {
        return delivery;
    }

    public void setDelivery(ZonedDateTime delivery) {
        this.delivery = delivery;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ShareTransaction{" +
                "id=" + id +
                ", person=" + person +
                ", item=" + item +
                ", delivery=" + delivery +
                ", type='" + type + '\'' +
                ", success=" + success +
                '}';
    }
}
