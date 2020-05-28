package sample.controller;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.StockShare;

public class DetailsViewController {
    StockShare stockShare;
    Stage stockDetails = new Stage();
    VBox mainVBox = new VBox();

    DetailsViewController(StockShare stockShare) {
        this.stockShare = stockShare;
    }

    public void setUpDetails() {
        stockDetails.setTitle("Company Details");
        mainVBox.getChildren().addAll(setUpName(), setUpChart(), setUpPrice());
        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(mainVBox);

        Scene detailsScene = new Scene(mainLayout, 800, 500);
        stockDetails.setScene(detailsScene);
        stockDetails.show();
    }

    private HBox setUpName() {
        HBox companyDetails = new HBox();

        Label companyName = new Label(this.stockShare.getStockName());
        //companyName.setMinHeight(40);
        companyName.setPrefHeight(40);
        companyName.setPadding(new Insets(0, 10, 0, 0));
        Label sharePrice = new Label(String.valueOf(this.stockShare.getActualPrice()));
        sharePrice.setPrefHeight(40);
        companyDetails.getChildren().addAll(companyName, sharePrice);
        companyDetails.setPadding(new Insets(10, 10, 10, 10));

        return companyDetails;
    }

    private LineChart setUpChart() {

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("Price");

        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Stock Details");
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 15));
        series.getData().add(new XYChart.Data(3, 16));
        series.getData().add(new XYChart.Data(4, 17));
        series.getData().add(new XYChart.Data(5, 54));
        series.getData().add(new XYChart.Data(6, 64));
        series.getData().add(new XYChart.Data(7, 43));
        series.getData().add(new XYChart.Data(8, 54));
        series.getData().add(new XYChart.Data(9, 23));
        series.getData().add(new XYChart.Data(10, 43));

        series.setName("Stock Monitor");

        lineChart.getData().add(series);
        lineChart.setPadding(new Insets(10, 10, 10, 10));

        return lineChart;
    }

    private VBox setUpPrice() {
        VBox vBox = new VBox();
        HBox minPrice = new HBox();
        HBox maxPrice = new HBox();

        Label minPriceLabel = new Label("Minimum Price: ");
        Label maxPriceLabel = new Label("Maximum Price: ");
        Label testPrice = new Label("3.20");

        minPrice.setPadding(new Insets(10, 10, 10, 10));
        maxPrice.setPadding(new Insets(10, 10, 10, 10));

        minPrice.getChildren().addAll(minPriceLabel, testPrice);
        maxPrice.getChildren().addAll(maxPriceLabel, testPrice);

        vBox.getChildren().addAll(minPrice, maxPrice);

        return vBox;
    }
}
