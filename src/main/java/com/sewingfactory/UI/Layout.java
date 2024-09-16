package com.sewingfactory.UI;

import com.sewingfactory.UI.Components.NavBarFactory;
import com.sewingfactory.UI.Scenes.FirmScene;
import com.sewingfactory.UI.Scenes.Employees.AllEmployees;
import com.sewingfactory.UI.Scenes.Inventory.Inventory;
import com.sewingfactory.UI.Scenes.Products.AllProducts;
import com.sewingfactory.UI.Scenes.Reports.Reports;
import com.sewingfactory.UI.Scenes.Sales.Sales;
import com.sewingfactory.entities.Company;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Layout extends Scene{
    public Layout(Stage stage, HBox parent, Company company) {
        super(parent, 640, 480);
        FirmScene fs = new FirmScene(company);
        VBox navBar = NavBarFactory.buildNavBar(
            parent,
            fs,
            new AllEmployees(),
            new AllProducts(),
            new Inventory(),
            new Sales(),
            new Reports()
            );

        parent.getChildren().addAll(navBar, fs);

        stage.setScene(this);
        stage.show();
    }
}
