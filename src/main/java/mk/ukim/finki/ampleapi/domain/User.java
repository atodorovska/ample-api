package mk.ukim.finki.ampleapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_entity")
public class User {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "unique_auth")
    private String uniqueAuthenticator;

    @JsonIgnore
    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Long person;

    public User() {
    }

    public User(String username, String uniqueAuthenticator, Long person) {
        this.username = username;
        this.uniqueAuthenticator = uniqueAuthenticator;
        this.role = Role.USER;
        this.person = person;
    }

    public User(String username, String uniqueAuthenticator, String password, String email, Long person) {
        this.username = username;
        this.uniqueAuthenticator = uniqueAuthenticator;
        this.email = email;
        this.password = password;
        this.role = Role.USER;
        this.person = person;
    }

    public User(String username, String uniqueAuthenticator, String password, String email, Role role, Long person) {
        this.username = username;
        this.uniqueAuthenticator = uniqueAuthenticator;
        this.password = password;
        this.email = email;
        this.role = role;
        this.person = person;
    }

    public User(String username, String password, String email, Long person) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.USER;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public String getUniqueAuthenticator() {
        return uniqueAuthenticator;
    }

    public void setUniqueAuthenticator(String uniqueAuthenticator) {
        this.uniqueAuthenticator = uniqueAuthenticator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", person=" + person +
                '}';
    }
}
