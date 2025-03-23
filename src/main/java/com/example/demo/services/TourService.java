package com.example.demo.services;

import com.example.demo.models.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class TourService {
    ObservableList<Tour> tours = FXCollections.observableArrayList(new Tour(
            0,
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
                tours.size(),
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

    public void editTour(int id, String newName){
      List<Tour> filteredTour =   tours.stream().filter(tour -> tour.getId() == id).toList();
      int index = tours.indexOf(filteredTour.getFirst());
      Tour tourToUpdate = tours.get(index);
      tourToUpdate.setName(newName);
    }

    public void deleteTour(Tour tour){
        tours.remove(tour);
    }

    public ObservableList<Tour> getTours(){
        return tours;
    }
}
