package sample.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.model.StockShare;
import sample.model.UserData;

import java.util.Collections;

public class DetailsViewController {
    private UserData userData;
    StockShare stockShare;
    Stage stockDetails = new Stage();
    VBox mainVBox = new VBox();

    Double operationValue;
    int sharesAmount;
    boolean buyPermision = false;

    DetailsViewController(StockShare stockShare) {
        this.stockShare = stockShare;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public void setUpDetails() {
        stockDetails.setTitle("Company Details");
        mainVBox.getChildren().addAll(setUpName(), setUpChart(), setUpOperation());
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

        ObservableList<XYChart.Data> chartData;

        int i = 1;
        for(Double price : stockShare.getPriceHistory()) {
            series.getData().add(new XYChart.Data(i, price));
            i += 1;
        }
        System.out.println(stockShare.getPriceHistory());
        series.setName("Stock Monitor");

        lineChart.getData().add(series);
        lineChart.setPadding(new Insets(10, 10, 10, 10));


        return lineChart;
    }

    private HBox setUpOperation() {
        HBox operationBox = new HBox();

        VBox priceBox = new VBox();
        HBox minPrice = new HBox();
        HBox maxPrice = new HBox();

        Label minPriceLabel = new Label("Minimum Price: ");
        Label maxPriceLabel = new Label("Maximum Price: ");
        Label testPrice = new Label("3.20");
        minPrice.setPadding(new Insets(10, 10, 10, 10));
        maxPrice.setPadding(new Insets(10, 10, 10, 10));
        minPrice.getChildren().addAll(minPriceLabel, testPrice);
        maxPrice.getChildren().addAll(maxPriceLabel, testPrice);

        priceBox.getChildren().addAll(minPrice, maxPrice);

        VBox operationDetailsBox = new VBox();

        HBox buttonsInfoBox = new HBox();
        Button buyButton = new Button("Buy");
        Button sellButton = new Button("Sell");

        Label operationValueLabel = new Label("Operation price: ");
        buyButton.setPadding(new Insets(10,10,10,10));
        sellButton.setPadding(new Insets(10,10,10,10));
        operationValueLabel.setPadding(new Insets(10,10,10,10));

//        operationDetailsBox.setPrefSize(amountTextField.getPrefWidth(),amountTextField.getPrefHeight());
        operationValueLabel.setTextAlignment(TextAlignment.CENTER);

        Label availableUserCash = new Label("Available cash: " + userData.getCash());

        TextField amountTextField = new TextField();
        amountTextField.setPromptText("Enter amount to buy/sell...");
        amountTextField.setPrefSize(200,40);
        amountTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.equals("")) {
                sharesAmount = Integer.valueOf(newValue);
                operationValue = stockShare.getActualPrice() * Double.valueOf(newValue);
                buyPermision = true;
                operationValueLabel.setText("Operation price: " + operationValue);
            } else {
                buyPermision = false;
            }
        });

        buyButton.setPrefSize(amountTextField.getPrefWidth()/2,amountTextField.getPrefHeight());
        sellButton.setPrefSize(amountTextField.getPrefWidth()/2,amountTextField.getPrefHeight());
        operationValueLabel.setPrefSize(amountTextField.getPrefWidth(),amountTextField.getPrefHeight());

        buyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buyButtonPressed();
                availableUserCash.setText(getUserCashString(userData.getCash()));
            }
        });

        sellButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sellButtonPressed();
                availableUserCash.setText(getUserCashString(userData.getCash()));
            }
        });

        buttonsInfoBox.setPadding(new Insets(10,20,10,20));
        buttonsInfoBox.getChildren().addAll(buyButton, sellButton);
        operationDetailsBox.getChildren().addAll(amountTextField, operationValueLabel, availableUserCash, buttonsInfoBox);
        operationBox.getChildren().addAll(priceBox,operationDetailsBox);

        return operationBox;
    }

    private void buyButtonPressed() {
        if (buyPermision) {
            this.stockShare = userData.buyStockShare(stockShare, sharesAmount);
        }
    }

    private void sellButtonPressed() {
        if (sharesAmount <= stockShare.getNumberOfShares()) {
            this.stockShare = userData.sellStockShare(stockShare, sharesAmount);
        }
    }

    private String getUserCashString(double userCash) {
        return "Available cash: " + userCash;
    }

}
