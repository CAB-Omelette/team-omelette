package com.codeup.omelette_abc.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;

    public User() {
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = email;
        this.password = password;
    }

    public User(long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = email;
        this.password = password;
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        username = copy.email;
        password = copy.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

}
