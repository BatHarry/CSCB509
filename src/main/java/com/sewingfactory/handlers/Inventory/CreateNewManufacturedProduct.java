package com.sewingfactory.handlers.Inventory;

import java.util.Optional;

import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.entities.ManufacturedLeatherDetail;
import com.sewingfactory.utils.InventoryStats;

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
        InventoryStats is1 = new InventoryStats(ld.getId());
        // Optional<InventoryStats> is =  productsObservable.stream()
        //     .filter(i -> i.getId().equals(ld.getId()))
        //     .findFirst();

        //     is.ifPresentOrElse(
        //     i -> {},
        //     () -> productsObservable.add(new InventoryStats(ld.getId(), ld.getName(), ld.getBasePrice(), 0L))
        // );

        System.out.println(productsObservable.indexOf(is1));
        int index = productsObservable.indexOf(is1);

        if(index != -1 ) {
            InventoryStats po = productsObservable.get(index);
            po.setCount(po.getCount() + 1);
            productsObservable.set(index, po);
        } else {
            productsObservable.add(new InventoryStats(ld.getId(), ld.getName(), ld.getBasePrice(), 1L));
        }

        // productsObservable.forEach(p -> {
        //     if (p.getId() == ld.getId()) {
        //         p.setCount(p.getCount()  + 1);
        //         productsObservable.set(0, p);
        //     }
        // });

        table.refresh();
        ManufacturedLeatherDetail mld = new ManufacturedLeatherDetail(employee, ld);
        ManufactureLeatherDetailDAL.createManufactureLeatherDetailDAL(mld);
    }
}
