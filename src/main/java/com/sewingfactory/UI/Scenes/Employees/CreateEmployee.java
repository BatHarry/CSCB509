package com.sewingfactory.UI.Scenes.Employees;

import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.handlers.Employee.CreateNewEmployeeHandler;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class CreateEmployee extends BaseScene {
    public CreateEmployee(ObservableList<Employee> employees) {
        super();
        Text headLine = HeadLineFactory.create("Добавяне на\nнов служител");

        Label nameLabel = new Label("Име на служителя:");
        TextField nameField = new TextField();

        Label familyLabel = new Label("Фамилия на служителя:");
        TextField familyField = new TextField();

        Label experienceLabel = new Label("Опит:");
        ChoiceBox<String> experienceField = new ChoiceBox<String>();
        experienceField.getItems().addAll("Младши", "Опитен");

        Button submit = new Button("Запиши");

        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, new CreateNewEmployeeHandler(nameField, familyField, experienceField, employees));

        this.getChildren().addAll(
            headLine, 
            nameLabel, 
            nameField,
            familyLabel,
            familyField,
            experienceLabel,
            experienceField,
            submit
            );
    }
}
