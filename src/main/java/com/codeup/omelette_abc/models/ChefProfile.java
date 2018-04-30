package com.codeup.omelette_abc.models;


import javax.persistence.*;

@Entity
@Table(name="chef_profile")
public class ChefProfile {

    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false, length = 50)
    private String first_name;

    @Column(nullable = false, length = 50)
    private String last_name;

    @Column(nullable = false, length = 50)
    private String profession;

    @Column(nullable = false, length = 500)
    private String bio;

    @Column(nullable = false, length = 200)
    private String picture;

    @Column(nullable = false, length = 30)
    private String phone;

    @Column(nullable = true, length = 500)
    private String video;

    public ChefProfile(String first_name, String last_name, String profession, String bio, String phone, String picture, String video) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.profession = profession;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public void setVideo(String video) {
        this.video = video;
    }

}

