package com.example.demo.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tour {
    int id;
    StringProperty name = new SimpleStringProperty();
    String description;
    String from;
    String to;
    String transportType;
    float distance;
    float estTime;
    private String routeImagePath;

    public Tour(int id, String name, String description, String from, String to, String transportType, float distance, float estTime) {
        this.id = id;
        this.name.set(name);
        this.description = description;
        this.from = from;
        this.to = to;
        this.transportType = transportType;
        this.distance = distance;
        this.estTime = estTime;
    }

    @Override
    public String toString() {
        return name.getValue();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getEstTime() {
        return estTime;
    }

    public void setEstTime(float estTime) {
        this.estTime = estTime;
    }

    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name.set(name);
    }

    public String getRouteImagePath() {
        return routeImagePath;
    }

    public void setRouteImagePath(String routeImagePath) {
        this.routeImagePath = routeImagePath;
    }
}
