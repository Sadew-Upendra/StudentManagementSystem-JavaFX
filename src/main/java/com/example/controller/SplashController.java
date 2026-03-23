package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class SplashController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private Label lblStatus;

    @FXML
    private ProgressBar progressBar;

    public void setStatus(String status) {
        lblStatus.setText(status);
    }

    public void setProgress(double value) {
        progressBar.setProgress(value);
    }
}