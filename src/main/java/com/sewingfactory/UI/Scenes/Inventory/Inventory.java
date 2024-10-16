package com.sewingfactory.UI.Scenes.Inventory;

import java.util.List;

import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;
import com.sewingfactory.utils.InventoryStats;

import javafx.beans.property.SimpleLongProperty;
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

// TODO For every product type there should be a quantity + price
public class Inventory extends BaseScene {
    @SuppressWarnings("unchecked")
    public Inventory(HBox parent, ObservableList<InventoryStats> productsObservable) {
        super();
        Text headLine = HeadLineFactory.create("Наличности");
        HBox tableContainer = new HBox(10);
        TableView<InventoryStats> table = new TableView<>();
        table.setItems(productsObservable);

        TableColumn<InventoryStats, String> productNameCol = new TableColumn<>("Продукт");
        productNameCol.setCellValueFactory(
            product -> {
                return new SimpleStringProperty(product.getValue().getName());
            }
        );

        TableColumn<InventoryStats, Number> quantityCol = new TableColumn<>("Налични бройки");
        quantityCol.setCellValueFactory(
            product -> {
                return new SimpleLongProperty(product.getValue().getCount());
            }
        );

        Button createNewButton = new Button("Добави нов продукт");

        tableContainer.getChildren().addAll(table, createNewButton);

        table.getColumns().setAll(
            productNameCol, 
            quantityCol
            );

        this.getChildren().addAll(
            headLine,
            tableContainer
        );

        createNewButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                parent.getChildren().remove(1);
                parent.getChildren().add(new ProductCreation(productsObservable, table));
            }
        });
    }
}
