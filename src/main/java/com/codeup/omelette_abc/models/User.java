package com.codeup.omelette_abc.models;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isOwner;

    public User(String email, String password, boolean isOwner) {
        this.email = email;
        this.password = password;
        this.isOwner = isOwner;
    }

    public User(long id, String email, String password, boolean isOwner) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.isOwner = isOwner;
    }

    public User(User copy) {
        id = copy.id;
        email = copy.email;
        password = copy.password;
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

    public boolean isOwner() {
        return isOwner;
    }

    public void setOwner(boolean owner) {
        isOwner = owner;
    }
}
