package com.example.demo.services;

import com.example.demo.models.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class TourService {
    private int idCounter = 1;

    private final ObservableList<Tour> tours = FXCollections.observableArrayList(
            new Tour(
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

    // Neue Version: erstellt eine komplette Tour
    public void createTour(String name, String description, String from, String to, String transportType, float distance, float estTime) {
        Tour newTour = new Tour(idCounter++, name, description, from, to, transportType, distance, estTime);
        tours.add(newTour);
    }

    // Neue Version: ersetzt alle Eigenschaften der Tour mit gleicher ID
    public void editTour(Tour updatedTour) {
        Tour originalTour = tours.stream()
                .filter(tour -> tour.getId() == updatedTour.getId())
                .findFirst()
                .orElse(null);

        if (originalTour != null) {
            originalTour.setName(updatedTour.getName());
            originalTour.setDescription(updatedTour.getDescription());
            originalTour.setFrom(updatedTour.getFrom());
            originalTour.setTo(updatedTour.getTo());
            originalTour.setTransportType(updatedTour.getTransportType());
            originalTour.setDistance(updatedTour.getDistance());
            originalTour.setEstTime(updatedTour.getEstTime());
        }
    }

    public void deleteTour(Tour tour) {
        tours.remove(tour);
    }

    public ObservableList<Tour> getTours() {
        return tours;
    }
}
