package com.codeup.omelette_abc.models;

import javax.persistence.*;


@Entity
@Table(name="job_listings")
public class JobListing {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 50)
    private String description;

    @Column(length = 255)
    private String pay;

    @OneToOne
    private User user;

    public JobListing(String title, String description, String pay) {
        this.title = title;
        this.description = description;
        this.pay = pay;
    }

    public JobListing(Long id, String title, String description, String pay, User user){
        this.id = id;
        this.title = title;
        this.description = description;
        this.pay = pay;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobListing(JobListing copy) {
        id = copy.id;
        title = copy.title;
        description = copy.description;
        pay = copy.pay;
    }


    public JobListing() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
