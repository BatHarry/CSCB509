package com.sewingfactory.UI.Scenes.Employees;

import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CreateEmployee extends BaseScene {
    public CreateEmployee() {
        super();
        Text headLine = HeadLineFactory.create("Добавяне на\nнов служител");

        Label nameLabel = new Label("Име на служителя:");
        TextField nameField = new TextField();

        Label familyLabel = new Label("Фамилия на служителя:");
        TextField familyField = new TextField();

        Label experienceLabel = new Label("Опит:");
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
