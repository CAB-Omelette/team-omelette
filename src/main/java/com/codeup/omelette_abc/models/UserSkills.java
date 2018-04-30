package com.codeup.omelette_abc.models;


import javax.persistence.*;

@Entity
@Table(name="user_skills")
public class UserSkills {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 500)
    private String video;

    @Column(length = 500)
    private String picture;

    public UserSkills(String video, String picture) {
        this.video = video;
        this.picture = picture;
    }

    public UserSkills() {
    }

    public UserSkills(String video) {
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
}
