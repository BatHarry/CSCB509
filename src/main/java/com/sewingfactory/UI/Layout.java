package com.sewingfactory.UI;

import java.util.List;

import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.UI.Components.NavBarFactory;
import com.sewingfactory.UI.Scenes.FirmScene;
import com.sewingfactory.UI.Scenes.Employees.AllEmployees;
import com.sewingfactory.UI.Scenes.Inventory.Inventory;
import com.sewingfactory.UI.Scenes.Products.AllProducts;
import com.sewingfactory.UI.Scenes.Reports.Reports;
import com.sewingfactory.UI.Scenes.Sales.Sales;
import com.sewingfactory.entities.Company;
import com.sewingfactory.utils.InventoryStats;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Layout extends Scene{
    public Layout(Stage stage, HBox parent, Company company) {
        super(parent, 640, 480);

        List<InventoryStats> products = ManufactureLeatherDetailDAL.getManufacturedLeatherDetailsInventoryWithPrice();
        ObservableList<InventoryStats> productsObservable = FXCollections.observableArrayList(products);

        FirmScene fs = new FirmScene(company);
        VBox navBar = NavBarFactory.buildNavBar(
            parent,
            fs,
            new AllEmployees(parent),
            new AllProducts(parent),
            new Inventory(parent, productsObservable),
            new Sales(productsObservable),
            new Reports()
            );

        parent.getChildren().addAll(navBar, fs);

        stage.setScene(this);
        stage.show();
    }
}
