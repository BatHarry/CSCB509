package com.sewingfactory.UI.Scenes.Employees;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;

import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;
import com.sewingfactory.configurations.SessionFactoryUtil;
import com.sewingfactory.entities.Employee;
import com.sewingfactory.entities.LeatherDetail;
import com.sewingfactory.entities.ManufacturedLeatherDetail;

import org.hibernate.Transaction;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class EmployeeProducts extends BaseScene {
    @SuppressWarnings("unchecked")
    public EmployeeProducts(Employee employee) {
        super();
        Text headLine = HeadLineFactory.create("Продукти на служител:\n" + employee.getFirstName() + " " + employee.getLastName());

        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.refresh(employee);
        tx.commit();

        List<ManufacturedLeatherDetail> products = employee.getManufacturedLeatherDetail();
        HashMap<Long, Long> occurrencesCounts = new HashMap<Long, Long>();

        products.stream().forEach(p -> {
            Long id = p.getLeatherDetail().getId();
            Long oldValue = occurrencesCounts.get(id);

            if(oldValue == null) 
                oldValue = 0L;

            occurrencesCounts.put(id, oldValue + 1);
        });

        List<EmployeeProductsStats> stats = products.stream().distinct().map(p -> {
            LeatherDetail ld = p.getLeatherDetail();
            return new EmployeeProductsStats(
                ld.getName(),
                ld.getBasePrice(),
                p.getPriceForManufacturing(),
                occurrencesCounts.get(p.getLeatherDetail().getId())
            );
        }).toList();

        ObservableList<EmployeeProductsStats> productsObservable = FXCollections.observableArrayList(stats);
        TableView<EmployeeProductsStats> table = new TableView<>();
        table.setItems(productsObservable);

        TableColumn<EmployeeProductsStats, String> productName = new TableColumn<>("Име");
        productName.setCellValueFactory(
            product -> {
                return new SimpleStringProperty(product.getValue().getProductName());
            }
            );

        TableColumn<EmployeeProductsStats, Number> price = new TableColumn<>("Продажна цена");
        price.setCellValueFactory(
            product -> {
                return new SimpleDoubleProperty(product.getValue().getSellingPrice());
            }
            );

        TableColumn<EmployeeProductsStats, Number> manufacturingCost = new TableColumn<>("Цена за изработка");
        manufacturingCost.setCellValueFactory(
            product -> {
                return new SimpleDoubleProperty(product.getValue().getManufacturedPrice());
            }
            );
        
        TableColumn<EmployeeProductsStats, Number> quantity = new TableColumn<>("Количество");
        quantity.setCellValueFactory(
            product -> {
                return new SimpleLongProperty(product.getValue().getQuantity());
            }
            );

        table.getColumns().setAll(
            productName, 
            price,
            manufacturingCost,
            quantity
            );

        this.getChildren().addAll(
            headLine,
            table
            );
    }

    private class EmployeeProductsStats {
        private String productName;
        private Double sellingPrice;
        private Double ManufacturedPrice;
        private Long quantity;

        public EmployeeProductsStats(String productName, Double sellingPrice, Double manufacturedPrice, Long quantity) {
            this.productName = productName;
            this.sellingPrice = sellingPrice;
            ManufacturedPrice = manufacturedPrice;
            this.quantity = quantity;
        }

        public String getProductName() {
            return productName;
        }
        public Double getSellingPrice() {
            return sellingPrice;
        }
        public Double getManufacturedPrice() {
            return ManufacturedPrice;
        }
        public Long getQuantity() {
            return quantity;
        }
    }
}
