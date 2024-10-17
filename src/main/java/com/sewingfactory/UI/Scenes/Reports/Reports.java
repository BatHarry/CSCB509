package com.sewingfactory.UI.Scenes.Reports;

import com.sewingfactory.DAL.ManufactureLeatherDetailDAL;
import com.sewingfactory.UI.Components.HeadLineFactory;
import com.sewingfactory.UI.Scenes.BaseScene;

import javafx.scene.text.Text;

public class Reports extends BaseScene {
    private Double[] report = ManufactureLeatherDetailDAL.getReport();
    private Double profit = report[0] - report[1];
    private Double tax = report[0] * 0.1;
    private Double totalProfit = profit - tax;

    private Text income = new Text("Приходи: " + report[0] + "лв");
    private Text expenses = new Text("Разходи: "+ report[1] +"лв");
    private Text profitLabel = new Text("Печалба: " + profit + "лв");
    private Text taxLabel = new Text("Данък: " + tax + "лв");
    private Text totalProfitLabel = new Text("Чиста печалба: " + totalProfit + "лв");


    public Reports() {
        super();
        Text headLine = HeadLineFactory.create("Отчети");

        if(report[0] == null || report[1] == null) throw new Error("Could not get reports");

        this.getChildren().addAll(
            headLine,
            income,
            expenses,
            profitLabel,
            taxLabel,
            totalProfitLabel
            );
    }

    @Override
    public void refresh() {
        this.report = ManufactureLeatherDetailDAL.getReport();

        this.profit = report[0] - report[1];
        this.tax = report[0] * 0.1;
        this.totalProfit = profit - tax;

        this.income.setText("Приходи: " + report[0] + "лв");
        this.expenses.setText("Разходи: "+ report[1] +"лв");
        this.profitLabel.setText("Печалба: " + profit + "лв");
        this.taxLabel.setText("Данък: " + tax + "лв");
        this.totalProfitLabel.setText("Чиста печалба: " + totalProfit + "лв");

    }
}
