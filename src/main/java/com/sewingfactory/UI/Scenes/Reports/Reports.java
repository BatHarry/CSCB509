package com.sewingfactory.UI.Scenes.Reports;

import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;

import javafx.scene.text.Text;

public class Reports extends BaseScene {
    public Reports() {
        super();
        Double[] report = ManufactureLeatherDetailDAL.getReport();

        if(report[0] == null || report[1] == null) throw new Error("Could not get reports");

        System.out.println(report);

        Double profit = report[0] - report[1];
        Double tax = report[0] * 0.1;
        Double totalProfit = profit - tax;

        Text headLine = HeadLineFactory.create("Отчети");
        Text income = new Text("Приходи: " + report[0] + "лв");
        Text expenses = new Text("Разходи: "+ report[1] +"лв");
        Text profitLabel = new Text("Печалба: " + profit + "лв");
        Text taxLabel = new Text("Данък: " + tax + "лв");
        Text totalProfitLabel = new Text("Чиста печалба: " + totalProfit + "лв");

        this.getChildren().addAll(
            headLine,
            income,
            expenses,
            profitLabel,
            taxLabel,
            totalProfitLabel
            );
    }
}
