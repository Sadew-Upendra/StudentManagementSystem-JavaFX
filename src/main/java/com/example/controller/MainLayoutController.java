package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class MainLayoutController {

    @FXML
    private AnchorPane contentContext;

    public void initialize() {
        // Load dashboard by default when app starts
        try {
            navigateToDashboard(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void navigateToDashboard(ActionEvent event) throws IOException {
        setNode("/com/example/view/DashboardForm.fxml");
    }

    @FXML
    void navigateToRegistration(ActionEvent event) throws IOException {
        setNode("/com/example/view/StudentForm.fxml");
    }

    @FXML
    void navigateToReports(ActionEvent event) throws IOException {
        setNode("/com/example/view/ReportForm.fxml");
    }

    @FXML
    void exitApp(ActionEvent event) {
        System.exit(0);
    }

    private void setNode(String fxmlPath) throws IOException {
        Parent node = FXMLLoader.load(getClass().getResource(fxmlPath));
        contentContext.getChildren().clear();
        contentContext.getChildren().add(node);
        
        // Ensure the loaded page fills the whole center area
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setRightAnchor(node, 0.0);
    }
}