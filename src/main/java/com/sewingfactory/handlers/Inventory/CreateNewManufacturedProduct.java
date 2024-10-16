package com.sewingfactory.handlers.Inventory;

import com.sewingfactory.DAL.InventoryStats;
import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.entities.ManufacturedLeatherDetail;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class CreateNewManufacturedProduct implements EventHandler<MouseEvent> {
    private ChoiceBox<Employee> employeeSelect;
    private ChoiceBox<LeatherDetail> productSelect;
    private ObservableList<InventoryStats> productsObservable;
    private TableView<InventoryStats> table;

    public CreateNewManufacturedProduct(
        ChoiceBox<Employee> employeeSelect, 
        ChoiceBox<LeatherDetail> productSelect, 
        ObservableList<InventoryStats> productsObservable,
        TableView<InventoryStats> table
    ) {
        this.employeeSelect = employeeSelect;
        this.productSelect = productSelect;
        this.productsObservable = productsObservable;
        this.table = table;
    }

    @Override
    public void handle(MouseEvent e) {
        Employee employee = employeeSelect.getValue();
        LeatherDetail ld = productSelect.getValue();

        productsObservable.forEach(p -> {
            if (p.getId() == ld.getId()) {
                p.setCount(p.getCount()  + 1);
            }
        });

        table.refresh();
        ManufacturedLeatherDetail mld = new ManufacturedLeatherDetail(employee, ld);
        ManufactureLeatherDetailDAL.createManufactureLeatherDetailDAL(mld);
    }
}
