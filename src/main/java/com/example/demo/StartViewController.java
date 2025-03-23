package com.example.demo;

import com.example.demo.models.Tour;
import com.example.demo.services.TourService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.List;

public class StartViewController {
    TourService tourService = new TourService();

    @FXML
    ListView<Tour> toursListView;

    @FXML
    Button createTourButton;

    public void initialize() {
        ObservableList<Tour> tours = tourService.getTours();
        //ObservableList<String> tourNames = FXCollections.observableArrayList(tours.stream().map(tour -> tour.getName()).toList());
        toursListView.setItems(tours);

        toursListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                System.out.println("Selected: " + newVal);
            }
        });


    }

    public void onCreateTourButtonClicked(){
         tourService.createTour();
    }
}
