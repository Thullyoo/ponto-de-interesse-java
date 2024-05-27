package br.thullyoo.poi.entity;

import jakarta.persistence.*;

@Entity(name = "tb_poi")
public class Poi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name_poi")
    String name;

    @Column(name = "x_poi")
    Long x;

    @Column(name = "y_poi")
    Long y;

    public Poi() {
    }

    public Poi(String name, Long x, Long y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
