package com.aiss.f1api.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drivers")
public class DriverModel {
    public DriverModel(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long pos;

    private String name;
    
    private String nationality;
    private String car;
    private Long pts;
    private Integer year;
    


    public DriverModel(Long pos, String name, String nationality, String car, Long pts, Integer year) {
        this.pos = pos;
        this.name = name;
        this.nationality = nationality;
        this.car = car;
        this.pts = pts;
        this.year = year;
    }


    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Long return the pos
     */
    public Long getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(Long pos) {
        this.pos = pos;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return String return the car
     */
    public String getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(String car) {
        this.car = car;
    }

    /**
     * @return Long return the pts
     */
    public Long getPts() {
        return pts;
    }

    /**
     * @param pts the pts to set
     */
    public void setPts(Long pts) {
        this.pts = pts;
    }

    /**
     * @return Long return the year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
    }

}