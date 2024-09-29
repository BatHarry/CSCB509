package com.sewingfactory.UI.Scenes.Products;

import java.util.List;

import com.sewingfactory.DAL.LeatherDetailDAL;
import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;
import com.sewingfactory.entities.LeatherDetail;

import javafx.beans.property.SimpleFloatProperty;
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

public class AllProducts extends BaseScene {
    private CreateProduct createProduct;

    @SuppressWarnings("unchecked")
    public AllProducts(HBox parent) {
        super();
        Text headLine = HeadLineFactory.create("Всички продукти");
        HBox tableContainer = new HBox(10);
        List<LeatherDetail> products = LeatherDetailDAL.getAllLeatherDetails();
        ObservableList<LeatherDetail> productsObservable = FXCollections.observableArrayList(products);
        this.createProduct = new CreateProduct(productsObservable);
        TableView<LeatherDetail> table = new TableView<>();
        table.setItems(productsObservable);

        TableColumn<LeatherDetail, String> nameCol = new TableColumn<>("Име");
        nameCol.setCellValueFactory(
            product -> {
                return new SimpleStringProperty(product.getValue().getName());
            }
        );

        TableColumn<LeatherDetail, Number> priceCol = new TableColumn<>("Цена");
        priceCol.setCellValueFactory(
            product -> {
                return new SimpleFloatProperty(product.getValue().getBasePrice());
            }
        );

        TableColumn<LeatherDetail, Number> materialsPriceCol = new TableColumn<>("Цена материали");
        materialsPriceCol.setCellValueFactory(
            product -> {
                return new SimpleFloatProperty(product.getValue().getPriceForMaterials());
            }
        );

        TableColumn<LeatherDetail, Number> laborCol = new TableColumn<>("Труд (часове)");
        laborCol.setCellValueFactory(
            product -> {
                return new SimpleFloatProperty(product.getValue().getLaborInHours());
            }
        );

        Button createNewButton = new Button("Добави нов продукт");

        tableContainer.getChildren().addAll(table, createNewButton);

        table.getColumns().setAll(
            nameCol, 
            priceCol,
            materialsPriceCol,
            laborCol
            );

        this.getChildren().addAll(
            headLine,
            tableContainer
        );

        createNewButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                parent.getChildren().remove(1);
                parent.getChildren().add(AllProducts.this.createProduct);
            }
        });
    }
}
