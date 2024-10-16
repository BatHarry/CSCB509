package com.sewingfactory.handlers.Firm;

import com.sewingfactory.DAL.CompanyDAL;
import com.sewingfactory.entities.Company;
import com.sewingfactory.handlers.BaseHandler;
import com.sewingfactory.utils.EntityValidation;
import com.sewingfactory.utils.ValidationResponse;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class UpdateFirmHandler extends BaseHandler {
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

    @Override
    public void handle(MouseEvent e) {
        this.company.setName(this.nameInput.getText());
        this.company.setJuniorSalary(Float.parseFloat(this.juniorSalaryInput.getText()));
        this.company.setSeniorSalary(Float.parseFloat(this.seniorSalaryInput.getText()));

        ValidationResponse errors = new EntityValidation<Company>().validate(company);

        if(errors.hasError()) {
            this.showErrorDialog(errors.getErrorMessage());
            return;
        }

        CompanyDAL.upateCompany(company);
        this.showSuccessDialog("Успешно записани данни за компания", "Данните за компанията са успешно запазени.");
    }
}