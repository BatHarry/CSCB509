package com.sewingfactory.handlers.Products;

import com.sewingfactory.DAL.LeatherDetailDAL;

import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.handlers.BaseHandler;
import com.sewingfactory.utils.EntityValidation;
import com.sewingfactory.utils.ValidationResponse;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateProductHandler extends BaseHandler{
    private TextField nameInput;
    private TextField basePrice;
    private TextField costOfMaterials;
    private TextField laborInHours;
    private ObservableList<LeatherDetail> products;


    public CreateProductHandler(ObservableList<LeatherDetail> products, TextField nameInput, TextField basePrice, TextField costOfMaterials, TextField laborInHours) {
        this.products = products;
        this.nameInput = nameInput;
        this.basePrice = basePrice;
        this.costOfMaterials = costOfMaterials;
        this.laborInHours = laborInHours;
    }

    @Override
    public void handle(MouseEvent e) {
        LeatherDetail product = new LeatherDetail(
            this.nameInput.getText(),
            Double.parseDouble(this.basePrice.getText()),
            Float.parseFloat(this.laborInHours.getText()),
            Float.parseFloat(this.costOfMaterials.getText())
        );
        ValidationResponse errors = new EntityValidation<LeatherDetail>().validate(product);

        if(errors.hasError()) {
            this.showErrorDialog(errors.getErrorMessage());
            return;
        }

        this.products.add(product);
        LeatherDetailDAL.createLeatherDetail(product);
        this.showSuccessDialog("Успешно създаден нов продукт", "Данните за продукта са успешно запазени.");

        nameInput.clear();
        basePrice.clear();
        costOfMaterials.clear();
        laborInHours.clear();
    }
}
