package com.aiss.f1api.models;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "constructors")

public class ConstructorModel {
    public ConstructorModel() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private Long pos;

    private String team;

    private Integer pts;

    private Integer year;
    


    public ConstructorModel(Long pos, String team, Integer pts, Integer year) {
        this.pos = pos;
        this.team = team;
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
     * @return String return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @return Year return the year
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


    /**
     * @return Integer return the pts
     */
    public Integer getPts() {
        return pts;
    }

    /**
     * @param pts the pts to set
     */
    public void setPts(Integer pts) {
        this.pts = pts;
    }

}