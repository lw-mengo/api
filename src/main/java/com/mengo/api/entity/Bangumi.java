package com.mengo.api.entity;


import javax.persistence.*;

@Table(name = "bangumi")
@Entity
public class Bangumi {

    private Integer id;
    private String name;
    private String url;
    private Integer aid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}
