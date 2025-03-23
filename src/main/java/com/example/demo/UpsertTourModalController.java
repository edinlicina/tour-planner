package com.example.demo;

import com.example.demo.models.Tour;
import com.example.demo.services.RouteService;
import com.example.demo.services.TourService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class UpsertTourModalController {

    @FXML private TextField tourNameTextField;
    @FXML private TextField tourDescriptionField;
    @FXML private TextField tourFromField;
    @FXML private TextField toField;
    @FXML private TextField tourTransportField;
    @FXML private TextField tourDistanceField;
    @FXML private TextField tourTimeField;
    @FXML private ImageView routeImageView;

    private TourService tourService;
    private Tour editingTour;

    public void setTourService(TourService service) {
        this.tourService = service;
    }

    public void setTour(Tour tour) {
        this.editingTour = tour;

        if (tour != null) {
            tourNameTextField.setText(tour.getName());
            tourDescriptionField.setText(tour.getDescription());
            tourFromField.setText(tour.getFrom());
            toField.setText(tour.getTo());
            tourTransportField.setText(tour.getTransportType());
            tourDistanceField.setText(String.valueOf(tour.getDistance()));
            tourTimeField.setText(String.valueOf(tour.getEstTime()));

            showRoutePreview(tour.getFrom(), tour.getTo());
        }
    }

    public void onSaveTourButtonClicked() {
        if (!validateInput()) return;
        String name = tourNameTextField.getText();
        String description = tourDescriptionField.getText();
        String from = tourFromField.getText();
        String to = toField.getText();
        String transport = tourTransportField.getText();

        float distance;
        float estTime;

        try {
            distance = Float.parseFloat(tourDistanceField.getText());
            estTime = Float.parseFloat(tourTimeField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Bitte gültige Zahlen für Distanz und Zeit eingeben.");
            return;
        }

        if (editingTour != null) {
            Tour updated = new Tour(editingTour.getId(), name, description, from, to, transport, distance, estTime);
            tourService.editTour(updated);
        } else {
            tourService.createTour(name, description, from, to, transport, distance, estTime);
        }

        // Fenster schließen
        Stage stage = (Stage) tourNameTextField.getScene().getWindow();
        stage.close();
    }
    private void showRoutePreview(String from, String to) {
        RouteService routeService = new RouteService();
        Image image = routeService.generateRouteImage(from, to);
        routeImageView.setImage(image);
    }


    private boolean validateInput() {
        if (tourNameTextField.getText().isBlank() ||
                tourDescriptionField.getText().isBlank() ||
                tourFromField.getText().isBlank() ||
                toField.getText().isBlank() ||
                tourTransportField.getText().isBlank()) {

            System.out.println("Alle Felder müssen ausgefüllt sein.");
            return false;
        }

        try {
            Float.parseFloat(tourDistanceField.getText());
            Float.parseFloat(tourTimeField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Distanz und Zeit müssen gültige Zahlen sein.");
            return false;
        }

        return true;
    }

}
