package com.sewingfactory.UI.Scenes.Inventory;

import java.util.List;

import com.sewingfactory.DAL.EmployeeDAL;
import com.sewingfactory.DAL.InventoryStats;
import com.sewingfactory.DAL.LeatherDetailDAL;
import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.handlers.Inventory.CreateNewManufacturedProduct;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class ProductCreation extends BaseScene {
    public ProductCreation(ObservableList<InventoryStats> productsObservable, TableView<InventoryStats> table) {
        super();
        Text headLine = HeadLineFactory.create("Създаване на\nпродукт");

        Label productLabel = new Label("Продукт:");
        ChoiceBox<LeatherDetail> productField = new ChoiceBox<>(); 
        List<LeatherDetail> allProducts = LeatherDetailDAL.getAllLeatherDetails();
        productField.getItems().addAll(allProducts);
        productField.setConverter(new StringConverter<LeatherDetail>() {
            @Override
            public String toString(LeatherDetail ld) {
                if(ld != null) return ld.getName();

                return "Избери продукт";
            }

            @Override
            public LeatherDetail fromString(String ld) {
                return new LeatherDetail();
            }
        });

        Label employeeLabel = new Label("Изработил:");
        ChoiceBox<Employee> employeeField = new ChoiceBox<>(); 
        List<Employee> allEmployees = EmployeeDAL.getAllEmployees();
        employeeField.getItems().addAll(allEmployees);
        employeeField.setConverter(new StringConverter<Employee>() {
            @Override
            public String toString(Employee e) {
                if(e != null) return e.getFirstName() + " " + e.getLastName();

                return "Избери работник изработил продукта";
            }

            @Override
            public Employee fromString(String ld) {
                return new Employee();
            }
        });

        Button submit = new Button("Запиши");

        this.getChildren().addAll(
            headLine, 
            productLabel, 
            productField,
            employeeLabel,
            employeeField,
            submit
            );

        submit.addEventHandler(MouseEvent.MOUSE_CLICKED, new CreateNewManufacturedProduct(employeeField, productField, productsObservable, table));
    }
}
