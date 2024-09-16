package com.sewingfactory.UI.Components;

import com.sewingfactory.UI.Scenes.FirmScene;
import com.sewingfactory.UI.Scenes.Employees.AllEmployees;
import com.sewingfactory.UI.Scenes.Inventory.Inventory;
import com.sewingfactory.UI.Scenes.Products.AllProducts;
import com.sewingfactory.UI.Scenes.Reports.Reports;
import com.sewingfactory.UI.Scenes.Sales.Sales;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NavBarFactory {
    public static VBox buildNavBar(
        HBox hbox,
        FirmScene fs,
        AllEmployees al,
        AllProducts ap,
        Inventory i,
        Sales s,
        Reports r
    ) {
        VBox navBar = new VBox(15);
        navBar.setStyle("-fx-padding: 16;");
        navBar.getChildren().addAll(
            new NavItem("Данни за фирма", hbox, fs),
            new NavItem("Служители", hbox, al),
            new NavItem("Продукти", hbox, ap),
            new NavItem("Склад", hbox, i),
            new NavItem("Продажба", hbox, s),
            new NavItem("Отчети", hbox, r)
        );
        return navBar;
    }
}
