package com.sewingfactory.UI;

import com.sewingfactory.UI.Components.NavBarFactory;
import com.sewingfactory.UI.Scenes.FirmScene;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO Two column layout with navbar and content
public class Layout extends Scene{
    public Layout(Stage stage, HBox parent) {
        super(parent, 640, 480);
        VBox navBar = NavBarFactory.buildNavBar(parent);
        FirmScene homePage = new FirmScene();

        parent.getChildren().addAll(navBar, homePage);

        stage.setScene(this);
        stage.show();
    }
}
