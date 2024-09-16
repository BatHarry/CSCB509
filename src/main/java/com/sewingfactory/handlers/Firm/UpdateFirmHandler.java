package com.sewingfactory.handlers.Firm;

import com.sewingfactory.DAL.CompanyDAL;
import com.sewingfactory.entities.Company;

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

    @Override
    public void handle(MouseEvent e) {
        this.company.setName(this.nameInput.getText());
        this.company.setJuniorSalary(Float.parseFloat(this.juniorSalaryInput.getText()));
        this.company.setSeniorSalary(Float.parseFloat(this.seniorSalaryInput.getText()));
        CompanyDAL.upateCompany(company);
    }
}