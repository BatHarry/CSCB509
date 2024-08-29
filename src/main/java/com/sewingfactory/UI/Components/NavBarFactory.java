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
    public static VBox buildNavBar(HBox hbox) {
        NavItem nav1 = new NavItem("Данни за фирма", hbox, new FirmScene());
        NavItem nav2 = new NavItem("Служители", hbox, new AllEmployees());
        NavItem nav3 = new NavItem("Продукти", hbox, new AllProducts());
        NavItem nav4 = new NavItem("Склад", hbox, new Inventory());
        NavItem nav5 = new NavItem("Продажба", hbox, new Sales());
        NavItem nav6 = new NavItem("Отчети", hbox, new Reports());

        VBox navBar = new VBox(15);
        navBar.setStyle("-fx-padding: 16;");
        navBar.getChildren().addAll(
            nav1,
            nav2,
            nav3,
            nav4,
            nav5,
            nav6
        );
        return navBar;
    }
}
