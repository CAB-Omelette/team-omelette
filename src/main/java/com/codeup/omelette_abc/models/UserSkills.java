package com.codeup.omelette_abc.models;


import javax.persistence.*;

@Entity
@Table(name="user_skills")
public class UserSkills {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 500)
    private String video;

    public UserSkills(String video) {
        this.video = video;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
