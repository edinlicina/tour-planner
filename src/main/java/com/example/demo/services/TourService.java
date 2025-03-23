package com.example.demo.services;

import com.example.demo.models.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TourService {
    ObservableList<Tour> tours = FXCollections.observableArrayList(new Tour(
            "Testtour",
            "Eine Testtour",
            "Wien",
            "Sandzak",
            "Bus",
            1100,
            16
            )
    );

    public void createTour(){
        Tour newTour = new Tour(
                "Testtour2",
                "Eine Testtour2",
                "Wien",
                "Bosnien",
                "Bus",
                700,
                9
        );
        tours.add(newTour);
    }
    public void editTour(){

    }
    public void deleteTour(){

    }
    public void updateTour(){

    }
    public ObservableList<Tour> getTours(){
        return tours;
    }
}
