package com.example.demo;

import com.example.demo.models.Tour;
import com.example.demo.services.TourService;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class StartViewController {
    TourService tourService = new TourService();

    @FXML
    ListView<Tour> toursListView;

    public void initialize() {
        ObservableList<Tour> tours = tourService.getTours();
        //ObservableList<String> tourNames = FXCollections.observableArrayList(tours.stream().map(tour -> tour.getName()).toList());
        toursListView.setItems(tours);
    }

    public void onCreateTourButtonClicked() throws IOException {
        openUpsertModal(null);
    }

    private void openUpsertModal(Tour selectedTour) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("upsert-tour-modal-view.fxml"));
        Parent root = loader.load();
        UpsertTourModalController controller = loader.getController();
        controller.setTour(selectedTour);
        controller.setTourService(tourService);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void onDeleteTourButtonClicked() {
        Tour selectedTour = toursListView.getSelectionModel().selectedItemProperty().get();
        tourService.deleteTour(selectedTour);
    }

    public void onEditTourButtonClicked() throws IOException {
        Tour selectedTour = toursListView.getSelectionModel().selectedItemProperty().get();
        openUpsertModal(selectedTour);
    }

    public void onRefreshListClicked(){
        toursListView.refresh();
    }
    public void onShowDetailsButtonClicked() throws IOException {
        Tour selectedTour = toursListView.getSelectionModel().getSelectedItem();
        if (selectedTour == null) return;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("tour-details-view.fxml"));
        Parent root = loader.load();
        TourDetailsController controller = loader.getController();
        controller.setTour(selectedTour);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Tour Details");
        stage.show();
    }


}
