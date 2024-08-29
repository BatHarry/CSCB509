package com.sewingfactory;

import com.sewingfactory.UI.Components.NavBarFactory;
import com.sewingfactory.UI.Scenes.FirmScene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        HBox hbox = new HBox(10);
        VBox navBar = NavBarFactory.buildNavBar(hbox);
        VBox homePage = new FirmScene();

        hbox.getChildren().addAll(navBar, homePage);

        Scene scene = new Scene(
            hbox,
            640, 
            480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}