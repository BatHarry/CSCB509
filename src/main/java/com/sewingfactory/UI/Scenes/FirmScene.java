package com.sewingfactory.UI.Scenes;

import com.sewingfactory.entities.Company;
import com.sewingfactory.handlers.Firm.UpdateFirmHandler;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FirmScene extends BaseScene {
    TextField inputField = new TextField();
    TextField seniorEmployeeField = new TextField();
    TextField juniorEMployeeField = new TextField();    

    public FirmScene(Company company) {
        this.inputField.setText(company.getName());
        this.juniorEMployeeField.setText(String.valueOf(company.getJuniorSalary()));
        this.seniorEmployeeField.setText(String.valueOf(company.getSeniorSalary()));

        this.setSpacing(10);
        Text headLine = new Text("Данни за фирма");
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        Label resultLabel = new Label("Име на фирма:");
        Label seniorLabel = new Label("Заплата за старши служители:");
        Label juniorLabel = new Label("Заплата за младши служители:");
        Button submitButton = new Button("Запиши");

        submitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new UpdateFirmHandler(
            company, 
            this.inputField, 
            this.juniorEMployeeField, 
            this.seniorEmployeeField
            )
        );

        this.getChildren().addAll(
            headLine, 
            resultLabel, 
            this.inputField,
            seniorLabel,
            this.seniorEmployeeField,
            juniorLabel,
            this.juniorEMployeeField,
            submitButton
        );
    }
}
