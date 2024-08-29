package com.sewingfactory.UI.Scenes.Inventory;

import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ProductCreation extends BaseScene {
    public ProductCreation() {
        super();
        Text headLine = HeadLineFactory.create("Създаване на\nпродукт");

        Label nameLabel = new Label("Продукт:");
        TextField nameField = new TextField();

        Label familyLabel = new Label("Изработил:");
        TextField familyField = new TextField();

        this.getChildren().addAll(
            headLine, 
            nameLabel, 
            nameField,
            familyLabel,
            familyField
            );
    }
}
