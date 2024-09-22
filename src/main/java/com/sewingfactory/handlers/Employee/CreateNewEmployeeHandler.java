package com.sewingfactory.handlers.Employee;

import com.sewingfactory.DAL.EmployeeDAL;
import com.sewingfactory.entities.Employee;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateNewEmployeeHandler implements EventHandler<MouseEvent> {
    private TextField firstName;
    private TextField lastName;
    private ChoiceBox<String> experienced;
    private ObservableList<Employee> employees;

    public CreateNewEmployeeHandler(TextField firstName, TextField lastName, ChoiceBox<String> experienced, ObservableList<Employee> employees) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienced = experienced;
        this.employees = employees;
    }

    @Override
    public void handle(MouseEvent e) {
        Employee employee = new Employee(this.firstName.getText(), this.lastName.getText(), this.experienced.getValue() == "Опитен" ? true : false);
        this.employees.add(employee);
        EmployeeDAL.createEmployee(employee);
    }
}
