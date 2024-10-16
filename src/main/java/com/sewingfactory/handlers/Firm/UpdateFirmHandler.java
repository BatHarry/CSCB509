package com.sewingfactory.handlers.Firm;

import com.sewingfactory.DAL.CompanyDAL;
import com.sewingfactory.configurations.ValidationResponse;
import com.sewingfactory.entities.Company;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;


public class UpdateFirmHandler implements EventHandler<MouseEvent> {
    private Company company;
    private TextField nameInput;
    private TextField juniorSalaryInput;
    private TextField seniorSalaryInput;

    public UpdateFirmHandler(Company company, TextField name, TextField js, TextField ss) {
        super();
        this.company = company;
        this.nameInput = name;
        this.juniorSalaryInput = js;
        this.seniorSalaryInput = ss;
    }

    public void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Грешка");
        alert.setHeaderText("Грешно въведени данни");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    @Override
    public void handle(MouseEvent e) {
        this.company.setName(this.nameInput.getText());
        this.company.setJuniorSalary(Float.parseFloat(this.juniorSalaryInput.getText()));
        this.company.setSeniorSalary(Float.parseFloat(this.seniorSalaryInput.getText()));

        ValidationResponse errors = CompanyDAL.validateCompany(company);

        if(errors.hasError()) {
            this.showErrorDialog(errors.getErrorMessage());
        }

        CompanyDAL.upateCompany(company);
    }
}