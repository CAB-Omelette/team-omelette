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

    public JobListing(String title, String description, String pay) {
        this.title = title;
        this.description = description;
        this.pay = pay;
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
