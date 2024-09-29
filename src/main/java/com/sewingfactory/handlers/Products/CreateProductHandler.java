package com.sewingfactory.handlers.Products;

import com.sewingfactory.DAL.LeatherDetailDAL;
import com.sewingfactory.entities.LeatherDetail;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateProductHandler implements EventHandler<MouseEvent>{
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
            Float.parseFloat(this.basePrice.getText()),
            Float.parseFloat(this.costOfMaterials.getText()),
            Float.parseFloat(this.laborInHours.getText())
        );

        this.products.add(product);

        LeatherDetailDAL.createLeatherDetail(product);
    }
}
