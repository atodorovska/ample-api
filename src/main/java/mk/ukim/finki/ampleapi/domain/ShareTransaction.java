package mk.ukim.finki.ampleapi.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "share_transaction")
public class ShareTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long person;

    private Long item;

    private Date delivery;

    private String address;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Boolean success;

    public ShareTransaction() {
    }

    public ShareTransaction(Long person, Long item, Date delivery, String address, TransactionType type, Boolean success) {
        this.person = person;
        this.item = item;
        this.delivery = delivery;
        this.address = address;
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

    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ShareTransaction{" +
                "id=" + id +
                ", person=" + person +
                ", item=" + item +
                ", delivery=" + delivery +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", success=" + success +
                '}';
    }
}
