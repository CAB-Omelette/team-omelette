package com.codeup.omelette_abc.models;

import javax.persistence.*;

@Entity
@Table(name="skills")
public class Skills {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 300)
    private String skill_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public Skills(String skill_name) {

        this.skill_name = skill_name;
    }
}
