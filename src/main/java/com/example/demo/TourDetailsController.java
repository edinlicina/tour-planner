package com.example.demo;

import com.example.demo.models.Tour;
import com.example.demo.services.RouteService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TourDetailsController {

    @FXML private Label nameLabel;
    @FXML private Label descriptionLabel;
    @FXML private Label fromLabel;
    @FXML private Label toLabel;
    @FXML private Label transportLabel;
    @FXML private Label distanceLabel;
    @FXML private Label timeLabel;
    @FXML private ImageView routeImageView;

    public void setTour(Tour tour) {
        nameLabel.setText("Name: " + tour.getName());
        descriptionLabel.setText("Description: " + tour.getDescription());
        fromLabel.setText("From: " + tour.getFrom());
        toLabel.setText("To: " + tour.getTo());
        transportLabel.setText("Transport: " + tour.getTransportType());
        distanceLabel.setText("Distance: " + tour.getDistance() + " km");
        timeLabel.setText("Estimated Time: " + tour.getEstTime() + " h");

        RouteService routeService = new RouteService();
        Image image = routeService.generateRouteImage(tour.getFrom(), tour.getTo());
        routeImageView.setImage(image);
    }
}
