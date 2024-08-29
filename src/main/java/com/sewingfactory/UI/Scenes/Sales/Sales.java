package com.sewingfactory.UI.Scenes.Sales;

import java.util.List;

import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;
import com.sewingfactory.entities.LeatherDetail;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

// TODO Select multiple rows and mark them as sold when clicking the sale button
public class Sales extends BaseScene{
    @SuppressWarnings("unchecked")
    public Sales() {
        Text headLine = HeadLineFactory.create("Направи продажба");
        HBox tableContainer = new HBox(10);

        List<LeatherDetail> products = List.of(
            new LeatherDetail("TEST Product", 0)
        );
        ObservableList<LeatherDetail> productsObservable = FXCollections.observableArrayList(products);
        TableView<LeatherDetail> table = new TableView<>();
        table.setItems(productsObservable);

        TableColumn<LeatherDetail, String> firstNameCol = new TableColumn<>("Име");
        firstNameCol.setCellValueFactory(
            product -> {
                return new SimpleStringProperty(product.getValue().getName());
            }
        );

        TableColumn<LeatherDetail, String> familyNameCol = new TableColumn<>("Цена");
        familyNameCol.setCellValueFactory(
            product -> {
                return new SimpleStringProperty(String.valueOf(product.getValue().getBasePrice()));
            }
        );

        Button createNewButton = new Button("Добави нов продукт");

        tableContainer.getChildren().addAll(table, createNewButton);

        table.getColumns().setAll(
            firstNameCol, 
            familyNameCol
            );

        this.getChildren().addAll(
            headLine,
            tableContainer
        );
    }
}
