package com.codeup.omelette_abc.models;

import javax.persistence.*;


@Entity
@Table(name="rest_profile")
public class RestProfile {

    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1000)
    private String about;

    @Column
    private String picture;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zip;

    @OneToOne
    private User user;

    public RestProfile(Long id,
                       String name,
                       String about,
                       String picture,
                       String phone,
                       String street,
                       String city,
                       String state,
                       String zip,
                       User user) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.picture = picture;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.user = user;
    }

    public RestProfile(String name,
                       String about,
                       String picture,
                       String phone,
                       String street,
                       String city,
                       String state,
                       String zip,
                       User user) {
        this.name = name;
        this.about = about;
        this.picture = picture;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.user = user;
    }

    public RestProfile() {
    }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getZip() { return zip; }

    public void setZip(String zip) { this.zip = zip; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAbout() { return about; }

    public void setAbout(String about) { this.about = about; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }
}

