package com.example.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class Navigation {
    public static void navigate(Stage stage, String fxmlFile) throws IOException {
        URL resource = Navigation.class.getResource("/view/" + fxmlFile);
        if (resource != null) {
            Parent root = FXMLLoader.load(resource);
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        } else {
            System.err.println("FXML file not found: " + fxmlFile);
        }
    }
}