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
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
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

    public ChefProfile(Long id, String first_name, String last_name,  String bio, String phone, String picture, String video, User user) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.bio = bio;
        this.phone = phone;
        this.picture = picture;
        this.video = video;
        this.user = user;
    }

    public ChefProfile(String first_name, String last_name, String bio, String phone, String picture, String video) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.bio = bio;
        this.phone = phone;
        this.picture = picture;
        this.video = video;
    }

    public ChefProfile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

