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

    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name.set(name);
    }
}
