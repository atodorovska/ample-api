package mk.ukim.finki.ampleapi.domain.dto;

public class EditProfileDto {

    private String address;

    private String number;

    private String username;

    public EditProfileDto(String address, String username) {
        this.address = address;
        this.number = number;
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "EditProfileDto{" +
                "address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
