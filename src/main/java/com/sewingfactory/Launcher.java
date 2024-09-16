package com.sewingfactory;
// import com.sewingfactory.UI.Layout

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        HBox hbox = new HBox(10);
        // Layout layout = new Layout(stage, hbox);
        stage.setScene(new Scene(hbox, 100, 100));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}