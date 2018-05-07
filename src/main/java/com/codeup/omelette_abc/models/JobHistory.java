package com.codeup.omelette_abc.models;

import javax.persistence.*;


@Entity
@Table(name="job_history")
public class JobHistory {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String location;

    @Column
    private String title;

    @Column
    private String startDate;

    @Column
    private String endDate;

    @Column
    private String reasonLeft;

    @OneToOne
    private User user;

    public JobHistory(String location, String title, String startDate, String endDate, String reasonLeft) {
        this.location = location;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reasonLeft = reasonLeft;
    }

    public JobHistory(Long id, String location, String title, String startDate, String endDate, String reasonLeft, User user) {
        this.id = id;
        this.location = location;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reasonLeft = reasonLeft;
        this.user = user;
    }

    public JobHistory() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public String getEndDate() {
        return endDate;
    }

    public String getReasonLeft() {
        return reasonLeft;
    }

    public void setReasonLeft(String reasonLeft) {
        this.reasonLeft = reasonLeft;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
