package com.sewingfactory.UI.Components;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class NavItem extends Group{
    public NavItem(String t, HBox layout, VBox page){
        super();
        Rectangle r = new Rectangle();
        r.setX(0);
        r.setY(-30);
        r.setWidth(200);
        r.setHeight(50);
        r.setArcWidth(20);
        r.setArcHeight(20);
        r.setFill(Color.web("#B3C2F2"));

        this.setCursor(Cursor.HAND);

        this.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                r.setFill(Color.web("735CDD"));
            }
        });

        this.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                r.setFill(Color.web("#B3C2F2"));
            }
        });

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                layout.getChildren().remove(1);
                layout.getChildren().add(page);
            }
        });

        Text text = new Text(t);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setWrappingWidth(200);
        text.setFill(Color.WHITE);
        text.setFont(new Font(18));

        this.getChildren().addAll(r, text);
    }
}
