package com.codeup.omelette_abc.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="education")
public class Education {


    public Education(String name, Date graduationDate, String focus) {
        this.name = name;
        this.graduationDate = graduationDate;
        this.focus = focus;
    }

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 500)
    private String name;

    @Column(length = 500)
    private Date graduationDate;

    @Column(length = 500)
    private String focus;

    public String getName() {
        return focus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }
}
