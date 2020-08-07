package mk.ukim.finki.ampleapi.domain.dto;

import mk.ukim.finki.ampleapi.domain.Role;

public class ActiveUserDto {

    private String username;

    private String email;

    private Role role;

    private Integer points;

    private String address;

    public ActiveUserDto() {
    }

    public ActiveUserDto(String username, String email, Role role, Integer points, String address) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.points = points;
        this.address = address;
    }
}
