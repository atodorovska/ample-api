package mk.ukim.finki.ampleapi.domain.dto;

import mk.ukim.finki.ampleapi.domain.Role;

public class ActiveUserDto {

    private String username;

    private String email;

    private Role role;

    private Integer points;

    private String address;

    private String number;

    public ActiveUserDto() {
    }

    public ActiveUserDto(String username, String email, Role role, Integer points, String address, String number) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.points = points;
        this.address = address;
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ActiveUserDto{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", points=" + points +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
