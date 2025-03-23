package com.example.demo.models;

public class Tour {
    String name;
    String description;
    String from;
    String to;
    String transportType;
    float distance;
    float estTime;

    public Tour(String name, String description, String from, String to, String transportType, float distance, float estTime) {
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
        this.transportType = transportType;
        this.distance = distance;
        this.estTime = estTime;
    }

    @Override
    public String toString() {
        return name;
    }


}
