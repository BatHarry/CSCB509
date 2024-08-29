package com.sewingfactory.UI.Scenes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FirmScene extends VBox {
    public FirmScene() {
        this.setSpacing(10);
        Text headLine = new Text("Данни за фирма");
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        Label resultLabel = new Label("Име на фирма:");
        TextField inputField = new TextField();

        Label seniorLabel = new Label("Заплата за старши служители:");
        TextField seniorEmployeeField = new TextField();

        Label juniorLabel = new Label("Заплата за младши служители:");
        TextField juniorEMployeeField = new TextField();

        this.getChildren().addAll(
            headLine, 
            resultLabel, 
            inputField,
            seniorLabel,
            seniorEmployeeField,
            juniorLabel,
            juniorEMployeeField
            );
    }
}
