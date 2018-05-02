package com.codeup.omelette_abc.models;

import javax.persistence.*;


@Entity
@Table(name="education")
public class Education {


    public Education(String name, String graduationDate, String focus) {
        this.name = name;
        this.graduationDate = graduationDate;
        this.focus = focus;
    }

    public Education(Long id, String name, String graduationDate, String focus, User user) {
        this.id = id;
        this.name = name;
        this.graduationDate = graduationDate;
        this.focus = focus;
        this.user = user;
    }

    public Education() {
    }

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 500)
    private String name;

    @Column(length = 500)
    private String graduationDate;

    @Column(length = 500)
    private String focus;

    @OneToOne
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() { return id; }

    public String getGraduationDate() { return graduationDate; }

    public void setId(long id) { this.id = id; }

    public void setGraduationDate(String graduationDate) { this.graduationDate = graduationDate; }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
