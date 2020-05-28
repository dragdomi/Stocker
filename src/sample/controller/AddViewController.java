package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import sample.model.StockShare;

public class AddViewController {
    OverviewViewController overviewViewController = new OverviewViewController();

    /**
     *
     * @return tableViewBox
     */
    public VBox loadAddView() {
        VBox boughtStock = new VBox();

        boughtStock.setAlignment(Pos.CENTER);

        Label buyLabel = new Label("Buy Share");
        buyLabel.setPrefSize(120,66);

        TextField companyName = new TextField();
        companyName.setPromptText("Company Name");
        companyName.setPrefHeight(50);
        companyName.setPrefWidth(120);

        TextField stockIndex = new TextField();
        stockIndex.setPromptText("Stock Index");
        stockIndex.setPrefHeight(50);
        stockIndex.setPrefWidth(120);

        TextField sharePrice = new TextField();
        sharePrice.setPromptText("Share Price");
        sharePrice.setPrefHeight(50);
        sharePrice.setPrefWidth(120);

        TextField numberOfShares = new TextField();
        numberOfShares.setPromptText("Number Of Shares");
        numberOfShares.setPrefHeight(50);
        numberOfShares.setPrefWidth(120);


        Button buyCompanyButton = new Button("BUY");
        buyCompanyButton.setPrefWidth(120);
        buyCompanyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String sharePriceString = String.format("%s", sharePrice.getCharacters());
                String numberOfSharesString = String.format("%s", numberOfShares.getCharacters());
                Double sharePriceDouble = Double.valueOf(sharePriceString);
                Integer numberOfSharesInt = Integer.valueOf(numberOfSharesString);

                //Dodanie spolki do OverView
                overviewViewController.stocks.addStock(new StockShare(
                        companyName.getText(),
                        stockIndex.getText(),
                        sharePriceDouble,
                        numberOfSharesInt

                ));

                companyName.clear();
                stockIndex.clear();
                sharePrice.clear();
                numberOfShares.clear();
            }
        });

        boughtStock.setPadding(new Insets(10,10,10,10));

        boughtStock.getChildren().addAll(buyLabel,companyName,stockIndex,sharePrice,numberOfShares,buyCompanyButton);
        return boughtStock;
    }

}
