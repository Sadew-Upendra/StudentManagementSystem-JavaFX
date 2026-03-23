package com.example;

import com.example.controller.SplashController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        // 1. Load Splash Screen
        Parent splashRoot = FXMLLoader.load(getClass().getResource("/com/example/view/SplashScreen.fxml"));
        Stage splashStage = new Stage();
        splashStage.initStyle(StageStyle.TRANSPARENT); // Removes window borders
        Scene splashScene = new Scene(splashRoot);
        splashScene.setFill(Color.TRANSPARENT);
        splashStage.setScene(splashScene);
        splashStage.show();

        // 2. Background Task to load the main app
        new Thread(() -> {
            try {
                // Simulate loading/DB initialization for 3 seconds
                Thread.sleep(3000); 

                Platform.runLater(() -> {
                    try {
                        // 3. Load Main Form
                        Parent mainRoot = FXMLLoader.load(getClass().getResource("/com/example/view/MainLayout.fxml"));
                        Stage mainStage = new Stage();
                        mainStage.setScene(new Scene(mainRoot));
                        mainStage.setTitle("Student Management System");
                        mainStage.show();

                        // 4. Close Splash
                        splashStage.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }*/

    @Override
    public void start(Stage splashStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/SplashScreen.fxml"));
        Parent root = loader.load();
        
        // Get the controller instance from the loader
        SplashController controller = loader.getController();
        
        Scene scene = new Scene(root);
        scene.setFill(null); // Makes corners transparent
        splashStage.initStyle(StageStyle.TRANSPARENT);
        splashStage.setScene(scene);
        splashStage.show();

        // Background Thread to simulate loading
        new Thread(() -> {
            try {
                String[] steps = {"Loading Modules...", "Connecting Database...", "Preparing UI...", "Done!"};
                
                for (int i = 0; i < steps.length; i++) {
                    final double progress = (i + 1) * 0.25;
                    final String status = steps[i];
                    
                    // Update UI on the JavaFX Thread
                    Platform.runLater(() -> {
                        controller.setStatus(status);
                        controller.setProgress(progress);
                    });

                    Thread.sleep(1000); // 0.8s per step
                }

                Platform.runLater(() -> {
                    try {
                        // Load Main Window
                        Parent mainRoot = FXMLLoader.load(getClass().getResource("/com/example/view/MainLayout.fxml"));
                        Stage mainStage = new Stage();
                        mainStage.setScene(new Scene(mainRoot));
                        mainStage.show();
                        splashStage.close();
                    } catch (Exception e) { e.printStackTrace(); }
                });

            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}