package mk.ukim.finki.ampleapi.domain.dto;

public class DiscountTransactionDto {

    private Long discount;

    private String username;

    public DiscountTransactionDto(Long discount, String username) {
        this.discount = discount;
        this.username = username;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DiscountTransactionDto{" +
                "discount=" + discount +
                ", username='" + username + '\'' +
                '}';
    }
}
