package com.example.demo;

import com.example.demo.models.Tour;
import com.example.demo.services.TourService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;



public class UpsertTourModalController {
    private Tour tour;
    private TourService tourService;

    @FXML
    TextField tourNameTextField;

    public void setTour(Tour tour) {
        this.tour = tour;
        tourNameTextField.setText(tour.toString());
    }

    public void setTourService(TourService tourService){
        this.tourService = tourService;
    }

    public void initialize(){

    }
    public void onSaveTourButtonClicked(){
        tourService.editTour(tour.getId(), tourNameTextField.getText());
    }

}
