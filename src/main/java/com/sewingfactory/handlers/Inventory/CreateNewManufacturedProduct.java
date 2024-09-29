package com.sewingfactory.handlers.Inventory;

import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.entities.ManufacturedLeatherDetail;

import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

public class CreateNewManufacturedProduct implements EventHandler<MouseEvent> {
    private ChoiceBox<Employee> employeeSelect;
    private ChoiceBox<LeatherDetail> productSelect;

    public CreateNewManufacturedProduct(ChoiceBox<Employee> employeeSelect, ChoiceBox<LeatherDetail> productSelect) {
        this.employeeSelect = employeeSelect;
        this.productSelect = productSelect;
    }

    @Override
    public void handle(MouseEvent e) {
        Employee employee = employeeSelect.getValue();
        LeatherDetail ld = productSelect.getValue();
        ManufacturedLeatherDetail mld = new ManufacturedLeatherDetail(employee, ld);
        ManufactureLeatherDetailDAL.createManufactureLeatherDetailDAL(mld);
    }
}
