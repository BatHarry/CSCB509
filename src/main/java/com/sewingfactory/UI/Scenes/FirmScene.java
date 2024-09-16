package com.sewingfactory.UI.Scenes;

import com.sewingfactory.DAL.CompanyDAL;
import com.sewingfactory.entities.Company;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FirmScene extends VBox {
    TextField inputField = new TextField();
    TextField seniorEmployeeField = new TextField();
    TextField juniorEMployeeField = new TextField();    
    Company company;

    public FirmScene() {
        this.company = CompanyDAL.getCompanyById(1);
        System.out.println(this.company);
        this.setSpacing(10);
        Text headLine = new Text("Данни за фирма");
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        Label resultLabel = new Label("Име на фирма:");

        Label seniorLabel = new Label("Заплата за старши служители:");

        Label juniorLabel = new Label("Заплата за младши служители:");

        this.getChildren().addAll(
            headLine, 
            resultLabel, 
            this.inputField,
            seniorLabel,
            this.seniorEmployeeField,
            juniorLabel,
            this.juniorEMployeeField
            );
    }
}
