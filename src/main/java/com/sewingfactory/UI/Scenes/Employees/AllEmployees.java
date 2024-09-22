package com.sewingfactory.UI.Scenes.Employees;

import java.util.List;

import com.sewingfactory.DAL.EmployeeDAL;
import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;
import com.sewingfactory.entities.Employee;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class AllEmployees extends BaseScene {
    private CreateEmployee createEmployee;

    @SuppressWarnings("unchecked")
    public AllEmployees(HBox parent) {
        super();
        Text headLine = HeadLineFactory.create("Всички служители");
        HBox tableContainer = new HBox(10);

        List<Employee> employees = EmployeeDAL.getAllEmployees();
        ObservableList<Employee> employeesObservable = FXCollections.observableArrayList(employees);
        this.createEmployee = new CreateEmployee(employeesObservable);
        TableView<Employee> table = new TableView<>();
        table.setItems(employeesObservable);


        TableColumn<Employee, String> firstNameCol = new TableColumn<>("Име");
        firstNameCol.setCellValueFactory(
            employee -> {
                return new SimpleStringProperty(employee.getValue().getFirstName());
            }
            );

        TableColumn<Employee, String> familyNameCol = new TableColumn<>("Фамилия");
        familyNameCol.setCellValueFactory(
            employee -> {
                return new SimpleStringProperty(employee.getValue().getLastName());
            }
            );

        TableColumn<Employee, String> experienceCol = new TableColumn<>("Опит");
        experienceCol.setCellValueFactory(
            employee -> {
                return new SimpleStringProperty(employee.getValue().getExperienced() ? "Старши" : "Младши");
            }
            );

        table.getColumns().setAll(
            firstNameCol, 
            familyNameCol, 
            experienceCol
            );

        Button createNewButton = new Button("Добави нов служител");

        tableContainer.getChildren().addAll(table, createNewButton);

        this.getChildren().addAll(
            headLine,
            tableContainer
            );

        createNewButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                parent.getChildren().remove(1);
                parent.getChildren().add(AllEmployees.this.createEmployee);
            }
        });
    }
}
