package com.sewingfactory.UI.Scenes.Products;

import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateProduct extends BaseScene {
    public CreateProduct() {
        Text headLine = HeadLineFactory.create("Добавяне на\nнов продукт");

        Label nameLabel = new Label("Име на продукта:");
        TextField nameField = new TextField();

        Label familyLabel = new Label("Материал:");
        TextField familyField = new TextField();

        Label experienceLabel = new Label("Време за изработка:");
        TextField experienceField = new TextField();

        this.getChildren().addAll(
            headLine, 
            nameLabel, 
            nameField,
            familyLabel,
            familyField,
            experienceLabel,
            experienceField
            );

    }
}
