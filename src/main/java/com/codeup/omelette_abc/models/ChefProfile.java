package com.codeup.omelette_abc.models;


import javax.annotation.ManagedBean;
import javax.persistence.*;

@Entity
@Table(name="chef_profile")
public class ChefProfile {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, length = 1000)
    private String bio;

    @Column
    private String picture;

    @Column(nullable = false)
    private String phone;

    @Column
    private String video;

    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChefProfile(Long id, String firstName, String lastName, String bio, String phone, String picture, String video, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.phone = phone;
        this.picture = picture;
        this.video = video;
        this.user = user;
    }

    public ChefProfile(String firstName, String lastName, String bio, String phone, String picture, String video) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.phone = phone;
        this.picture = picture;
        this.video = video;
    }

    public ChefProfile(String firstName, String lastName, String bio, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.phone = phone;
    }

    public ChefProfile() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) { this.video = video; }

}

