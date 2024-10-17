package com.sewingfactory.handlers.Inventory;

import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.entities.ManufacturedLeatherDetail;
import com.sewingfactory.utils.InventoryStats;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

public class CreateNewManufacturedProduct implements EventHandler<MouseEvent> {
    private ChoiceBox<Employee> employeeSelect;
    private ChoiceBox<LeatherDetail> productSelect;
    private ObservableList<InventoryStats> productsObservable;

    public CreateNewManufacturedProduct(
        ChoiceBox<Employee> employeeSelect, 
        ChoiceBox<LeatherDetail> productSelect, 
        ObservableList<InventoryStats> productsObservable
    ) {
        this.employeeSelect = employeeSelect;
        this.productSelect = productSelect;
        this.productsObservable = productsObservable;
    }

    @Override
    public void handle(MouseEvent e) {
        Employee employee = employeeSelect.getValue();
        LeatherDetail ld = productSelect.getValue();

        if(ld == null || employee == null) return;

        InventoryStats is1 = new InventoryStats(ld.getId());
        int index = productsObservable.indexOf(is1);

        if(index != -1 ) {
            InventoryStats po = productsObservable.get(index);
            po.setCount(po.getCount() + 1);
            productsObservable.set(index, po);
        } else {
            productsObservable.add(new InventoryStats(ld.getId(), ld.getName(), ld.getBasePrice(), 1L));
        }

        ManufacturedLeatherDetail mld = new ManufacturedLeatherDetail(employee, ld);
        ManufactureLeatherDetailDAL.createManufactureLeatherDetailDAL(mld);
    }
}
