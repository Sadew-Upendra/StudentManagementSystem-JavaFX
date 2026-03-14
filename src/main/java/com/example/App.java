package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

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
                        Parent mainRoot = FXMLLoader.load(getClass().getResource("/com/example/view/StudentForm.fxml"));
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}