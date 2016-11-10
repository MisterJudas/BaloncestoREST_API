package com.eduardobenavides.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.time.LocalDate;

/**
 * Created by Amilcar on 10/10/2016.
 */
@Entity
/*@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"name", "surname"})
})*/
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    @JsonIgnore
    private LocalDate birthDate;
    private int points;
    private int assists;
    private int rebound;
    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne // un jugador sólo puede pertenecer a un equipo
    private Team team;

    public Player(){
    }

    /* Constructores */

    public Player(String name, String surname, LocalDate birthDate, int points, int assists, int rebound, Position position, Team team) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.points = points;
        this.assists = assists;
        this.rebound = rebound;
        this.position = position;
        this.team = team;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", points=" + points +
                ", assists=" + assists +
                ", rebound=" + rebound +
                ", position=" + position +
                ", team=" + team +
                '}';
    }
}