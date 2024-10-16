package com.sewingfactory.handlers;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public abstract class BaseHandler implements EventHandler<MouseEvent>{
    
    public void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Грешка");
        alert.setHeaderText("Грешно въведени данни");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    public void showSuccessDialog(String subHeader, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Успешна транзакция");
        alert.setHeaderText(subHeader);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
