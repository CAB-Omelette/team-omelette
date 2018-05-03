package com.codeup.omelette_abc.models;

import javax.persistence.*;


@Entity
@Table(name="job_history")
public class JobHistory {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String start_date;

    @Column(nullable = false)
    private String end_date;

    @Column(nullable = true)
    private String reason_left;

    @OneToOne
    private User user;

    public JobHistory(String location, String title, String start_date, String end_date, String reason_left) {
        this.location = location;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.reason_left = reason_left;
    }

    public JobHistory(Long id, String location, String title, String start_date, String end_date, String reason_left, User user) {
        this.id = id;
        this.location = location;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.reason_left = reason_left;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) { this.start_date = start_date; }

    public void setEnd_date(String end_date) { this.end_date = end_date; }

    public String getEnd_date() {
        return end_date;
    }

    public String getReason_left() {
        return reason_left;
    }

    public void setReason_left(String reason_left) {
        this.reason_left = reason_left;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
