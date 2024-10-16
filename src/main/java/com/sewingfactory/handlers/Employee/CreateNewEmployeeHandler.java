package com.sewingfactory.handlers.Employee;

import com.sewingfactory.DAL.EmployeeDAL;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.handlers.BaseHandler;
import com.sewingfactory.utils.EntityValidation;
import com.sewingfactory.utils.ValidationResponse;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateNewEmployeeHandler extends BaseHandler{
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
        ValidationResponse errors = new EntityValidation<Employee>().validate(employee);

        if(errors.hasError()) {
            this.showErrorDialog(errors.getErrorMessage());
            return;
        }

        this.employees.add(employee);
        EmployeeDAL.createEmployee(employee);
        this.showSuccessDialog("Успешно създаден служител", "Данните за новия служител бяха успешно запазени.");

        firstName.clear();
        lastName.clear();
    }
}
