package com.eduardobenavides.domain;

import javax.persistence.*;

/**
 * Created by Amilcar on 10/10/2016.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String surname;
    private int points;
    private int assists;
    private int rebound;
    private String position;

    // @ManyToOne // un jugador sólo puede pertenecer a un equipo
    // private Team team;

    /* Constructores */

    public Player(String name, String surname, int points, int assists, int rebound, String position) {
        this.name = name;
        this.surname = surname;
        this.points = points;
        this.assists = assists;
        this.rebound = rebound;
        this.position = position;
    }


    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getRebound() {
        return rebound;
    }

    public void setRebound(int rebound) {
        this.rebound = rebound;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", points=" + points +
                ", assists=" + assists +
                ", rebound=" + rebound +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (points != player.points) return false;
        if (assists != player.assists) return false;
        if (rebound != player.rebound) return false;
        if (id != null ? !id.equals(player.id) : player.id != null) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (surname != null ? !surname.equals(player.surname) : player.surname != null) return false;
        return position != null ? position.equals(player.position) : player.position == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + points;
        result = 31 * result + assists;
        result = 31 * result + rebound;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}

