package com.sewingfactory;
import com.sewingfactory.UI.Layout;
import com.sewingfactory.entities.Company;
import com.sewingfactory.utils.CompanySingleton;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        Company company = CompanySingleton.getCompany();

        HBox hbox = new HBox(10);
        new Layout(stage, hbox, company);
    }

    public static void main(String[] args) {
        launch();
    }

}