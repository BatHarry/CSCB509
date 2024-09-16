package com.sewingfactory;
import com.sewingfactory.DAL.CompanyDAL;
import com.sewingfactory.UI.Layout;
import com.sewingfactory.entities.Company;

import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {
        Company company;
        try {
            company = CompanyDAL.getCompanyById(1);
        } catch (Exception e) {
            System.out.println("Company not found");
            company = new Company("", 0, 0);
            CompanyDAL.createCompany(company);
            System.out.println("Blank company created");
        }

        HBox hbox = new HBox(10);
        Layout layout = new Layout(stage, hbox, company);
    }

    public static void main(String[] args) {
        launch();
    }

}