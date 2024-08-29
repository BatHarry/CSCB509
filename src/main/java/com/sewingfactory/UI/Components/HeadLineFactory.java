package com.sewingfactory.UI.Components;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HeadLineFactory {
    public static Text create(String t) {
        Text headLine = new Text(t);
        headLine.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 35));

        return headLine;
    }
}
