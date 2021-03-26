package com.codecool.raceresults;

public class F1Driver {
    private String name;
    private int point;

    public F1Driver(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }
}
