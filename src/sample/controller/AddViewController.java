package sample.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.model.StockShare;
import sample.model.Stocks;

public class AddViewController {
    private TableView<StockShare> overviewTable = new TableView<StockShare>();

    private final Stocks stocks = new Stocks(
            new StockShare("CDR", "WIG20", 346, 50),
            new StockShare("11bit", "mWIG40", 405.50, 123),
            new StockShare("PKNOrlen", "WIG30", 61.50, 30)
    );

    final ObservableList<StockShare> listOfStocks = stocks.getStocksList();

    /**
     *
     * @return tableViewBox
     */
    public VBox loadAddView() {
        Label yourSharesLabel = new Label("Your Stock Shares");
        overviewTable.setEditable(true);

        TableColumn<StockShare, String> companyName = new TableColumn<>("Company Name");
        TableColumn<StockShare, String> stockIndex = new TableColumn<>("Stock Index");
        TableColumn<StockShare, Double> sharePrice = new TableColumn("Purchase Price");
        TableColumn<StockShare, Integer> numberOfShares = new TableColumn("Number of Shares");
        TableColumn<StockShare, Double> totalValue = new TableColumn("Total Value");


        companyName.setCellValueFactory(new PropertyValueFactory<>("stockName"));
        stockIndex.setCellValueFactory(new PropertyValueFactory<>("stockIndex"));
        sharePrice.setCellValueFactory(new PropertyValueFactory<>("sharePrice"));
        numberOfShares.setCellValueFactory(new PropertyValueFactory<>("numberOfShares"));
        totalValue.setCellValueFactory(new PropertyValueFactory<>("totalValueOfShares"));


        companyName.setPrefWidth(116);
        stockIndex.setPrefWidth(116);
        sharePrice.setPrefWidth(116);
        numberOfShares.setPrefWidth(116);
        totalValue.setPrefWidth(116);


        overviewTable.setItems(listOfStocks);

        overviewTable.getColumns().addAll(companyName, stockIndex, sharePrice, numberOfShares, totalValue);


        VBox tableViewBox = new VBox();
        tableViewBox.setSpacing(5);

        tableViewBox.setPadding(new Insets(10, 10, 10, 10));
        tableViewBox.getChildren().addAll(yourSharesLabel, overviewTable, addNewCompanyToTableView(listOfStocks));

        return tableViewBox;
    }

    HBox addNewCompanyToTableView(ObservableList listOfStocks) {

        HBox addNewCompany = new HBox();

        TextField companyName = new TextField();
        companyName.setPromptText("Company Name");
        companyName.setPrefWidth(125);

        TextField stockIndex = new TextField();
        stockIndex.setPromptText("Stock Index");
        stockIndex.setPrefWidth(125);

        TextField sharePrice = new TextField();
        sharePrice.setPromptText("Share Price");
        sharePrice.setPrefWidth(125);

        TextField numberOfShares = new TextField();
        numberOfShares.setPromptText("Number Of Shares");
        numberOfShares.setPrefWidth(125);

        Button addCompanyButton = new Button("Add");
        addCompanyButton.setPrefWidth(80);
        addCompanyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String sharePriceString = String.format("%s", sharePrice.getCharacters());
                String numberOfSharesString = String.format("%s", numberOfShares.getCharacters());
                Double sharePriceDouble = Double.valueOf(sharePriceString);
                Integer numberOfSharesInt = Integer.valueOf(numberOfSharesString);

                stocks.addStock(
                        new StockShare(
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

        addNewCompany.getChildren().addAll(companyName, stockIndex, sharePrice, numberOfShares, addCompanyButton);


        return addNewCompany;
    }


}
