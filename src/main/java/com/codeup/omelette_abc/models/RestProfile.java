package com.codeup.omelette_abc.models;

import javax.persistence.*;


@Entity
@Table(name="rest_profile")
public class RestProfile {

    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false, length = 100)
    private String rest_name;

    @Column(nullable = false, length = 500)
    private String about;

    @Column(length = 250)
    private String picture;

    @Column(length = 250)
    private String video;

    @Column(nullable = false, length = 30)
    private String phone;

    @Column(nullable = false, length = 250)
    private String location;

    public RestProfile(String rest_name, String about, String picture, String phone, String video, String location) {
        this.rest_name = rest_name;
        this.about = about;
        this.picture = picture;
        this.video = video;
        this.location = location;
        this.phone = phone;
    }

    public RestProfile() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
