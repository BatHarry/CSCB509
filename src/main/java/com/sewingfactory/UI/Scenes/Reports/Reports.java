package com.sewingfactory.UI.Scenes.Reports;

import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;

import javafx.scene.text.Text;

public class Reports extends BaseScene {
    public Reports() {
        super();
        Text headLine = HeadLineFactory.create("Отчети");
        Text income = new Text("Приходи: 5000лв");
        Text expenses = new Text("Разходи: 4200лв");
        Text profit = new Text("Печалба: 5000лв");
        Text tax = new Text("Данък: 5000лв");
        Text totalProfit = new Text("Чисто: 5000лв");

        this.getChildren().addAll(
            headLine,
            income,
            expenses,
            profit,
            tax,
            totalProfit
            );
    }
}
