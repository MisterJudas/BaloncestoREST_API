package com.eduardobenavides.domain;
import javax.persistence.*;

/**
 * Created by 48092788H on 10/11/2016.
 */
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private Position position;
    private double avgPoints;
    private int minPoints;
    private int maxPoints;

    public Statistic(Position position, double avgPoints, int minPoints, int maxPoints) {
        this.position = position;
        this.avgPoints = avgPoints;
        this.minPoints = minPoints;
        this.maxPoints = maxPoints;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getAvgPoints() {
        return avgPoints;
    }

    public void setAvgPoints(double avgPoints) {
        this.avgPoints = avgPoints;
    }

    public int getMinPoints() {
        return minPoints;
    }

    public void setMinPoints(int minPoints) {
        this.minPoints = minPoints;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
}
