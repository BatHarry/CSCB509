package com.sewingfactory.UI.Scenes.Products;

import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;
import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.handlers.Products.CreateProductHandler;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class CreateProduct extends BaseScene {
    public CreateProduct(ObservableList<LeatherDetail> products) {
        Text headLine = HeadLineFactory.create("Добавяне на\nнов продукт");

        Label nameLabel = new Label("Име на продукта:");
        TextField nameField = new TextField();

        Label basePriceLabel = new Label("Продажна цена:");
        TextField basePriceField = new TextField();

        Label materialPriceLabel = new Label("Цена за материал:");
        TextField materialPriceField = new TextField();

        Label LaborInHoursLabel = new Label("Време за изработка (часове):");
        TextField LaborInHoursField = new TextField();

        Button submit = new Button("Запиши");

        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, new CreateProductHandler(products, nameField, basePriceField, materialPriceField, LaborInHoursField));

        this.getChildren().addAll(
            headLine, 
            nameLabel, 
            nameField,
            basePriceLabel,
            basePriceField,
            materialPriceLabel,
            materialPriceField,
            LaborInHoursLabel,
            LaborInHoursField,
            submit
            );

    }
}
