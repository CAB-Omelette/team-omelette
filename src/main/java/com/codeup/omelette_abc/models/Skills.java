package com.codeup.omelette_abc.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="skills")
public class Skills {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 500)
    private String video;

    @Column(length = 500)
    private String picture;

    @Column
    private String name;

    @OneToOne
    private User user;

    public Skills(String video, String picture, String name) {
        this.video = video;
        this.picture = picture;
        this.name = name;
    }

    public Skills(Long id, String video, String picture, String name, User user) {
        this.id = id;
        this.video = video;
        this.picture = picture;
        this.name = name;
        this.user = user;
    }

    public Skills() { }

    public Skills(String video) {
        this.video = video;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    private List<Skills> skill;

    public List<Skills> getSkills() { return skill; }

    public void setSkills(List<Skills> skill) { this.skill = skill; }

}
