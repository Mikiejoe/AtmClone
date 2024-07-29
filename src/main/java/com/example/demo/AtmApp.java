package com.example.demo;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AtmApp extends Application {
@Override
    public void start(Stage stage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signUp.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
    stage.setTitle("Hello!");
    stage.setScene(scene);
    stage.show();
//    URL fxmlLocation = getClass().getClassLoader().getResource("signUp.fxml");
//
//        FXMLLoader loader = new FXMLLoader(fxmlLocation);
//        Parent root = loader.load();
//
//        primaryStage.setScene(new Scene(root, 520, 400));
//        primaryStage.setTitle("ATM Application");
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

