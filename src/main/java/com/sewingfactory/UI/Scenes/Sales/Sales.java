package com.sewingfactory.UI.Scenes.Sales;

import java.util.List;
import javafx.util.Callback;

import com.sewingfactory.DAL.InventoryStats;
import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

// TODO Select multiple rows and mark them as sold when clicking the sale button
public class Sales extends BaseScene{
    @SuppressWarnings("unchecked")
    public Sales() {
        Text headLine = HeadLineFactory.create("Направи продажба");
        HBox tableContainer = new HBox(10);

        List<InventoryStats> products = ManufactureLeatherDetailDAL.getManufacturedLeatherDetailsInventoryWithPrice();
        ObservableList<InventoryStats> productsObservable = FXCollections.observableArrayList(products);
        TableView<InventoryStats> table = new TableView<>();
        table.setItems(productsObservable);

        TableColumn<InventoryStats, String> productNameCol = new TableColumn<>("Име");
        productNameCol.setCellValueFactory(
            product -> {
                return new SimpleStringProperty(product.getValue().getName());
            }
        );

        TableColumn<InventoryStats, Number> quantityCol = new TableColumn<>("Количество");
        quantityCol.setCellValueFactory(
            product -> {
                return new SimpleLongProperty(product.getValue().getCount());
            }
        );

        TableColumn<InventoryStats, Number> priceCol = new TableColumn<>("Цена");
        priceCol.setCellValueFactory(
            product -> {
                return new SimpleFloatProperty(product.getValue().getPrice());
            }
        );

        TableColumn buyCol = new TableColumn<>("Опции");
        buyCol.setCellFactory(
            new Callback<TableColumn<Record, Boolean>, TableCell<Record, Boolean>>() {
                @Override
                public TableCell<Record, Boolean> call(TableColumn<Record, Boolean> p) {
                    System.out.println(p.getUserData());
                    return new ButtonCell();
                }
            });

        tableContainer.getChildren().addAll(table);

        table.getColumns().setAll(
            productNameCol, 
            quantityCol,
            priceCol,
            buyCol
            );

        this.getChildren().addAll(
            headLine,
            tableContainer
        );
    }

    private class ButtonCell extends TableCell<Record, Boolean> {
        final Button cellButton = new Button("Продажба");
        
        ButtonCell(){
            cellButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    System.out.println(e);
                }
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }

}
