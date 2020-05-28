package sample.controller;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.StockShare;
import sample.model.Stocks;


public class OverviewViewController {
    public TableView<StockShare> overviewTable = new TableView<StockShare>();

    public final Stocks stocks = new Stocks(
            new StockShare("CDR", "WIG20", 346, 346),
            new StockShare("CDR", "WIG20", 346, 346),
            new StockShare("CDR", "WIG20", 346, 346)
    );

    private final ObservableList<StockShare> listOfStocks = stocks.getStocksList();

    /**
     * Method to load table view, overview of stocks
     * @return overviewTable
     */
    public VBox loadOverviewView () {
        Label overviewLabel = new Label("Overview");
        overviewTable.setEditable(true);

        TableColumn<StockShare, String> companyName = new TableColumn<>("Company Name");
        TableColumn<StockShare, String> stockIndex = new TableColumn<>("Stock Index");
        TableColumn<StockShare, Double> boughtPrice = new TableColumn("Bought Price");
        TableColumn<StockShare, Double> actualPrice = new TableColumn("Actual Price");
        TableColumn<StockShare, Double> change = new TableColumn("Change");
        TableColumn<StockShare, Double> changePercent = new TableColumn("Change (%)");
        TableColumn<StockShare, Integer> numberOfShares = new TableColumn("Number Of Shares");
        TableColumn<StockShare, Double> totalValueOfShares = new TableColumn("Total Value");

        companyName.setCellValueFactory(new PropertyValueFactory<>("stockName"));
        stockIndex.setCellValueFactory(new PropertyValueFactory<>("stockIndex"));
        boughtPrice.setCellValueFactory(new PropertyValueFactory<>("boughtPrice"));
        actualPrice.setCellValueFactory(new PropertyValueFactory<>("actualPrice"));
        change.setCellValueFactory(new PropertyValueFactory<>("change"));
        changePercent.setCellValueFactory(new PropertyValueFactory<>("changePercent"));
        numberOfShares.setCellValueFactory(new PropertyValueFactory<>("numberOfShares"));
        totalValueOfShares.setCellValueFactory(new PropertyValueFactory<>("totalValueOfShares"));


        companyName.setPrefWidth(116);
        stockIndex.setPrefWidth(116);
        boughtPrice.setPrefWidth(116);
        actualPrice.setPrefWidth(116);
        change.setPrefWidth(116);
        changePercent.setPrefWidth(116);
        numberOfShares.setPrefWidth(116);
        totalValueOfShares.setPrefWidth(116);

        overviewTable.setItems(listOfStocks);

        overviewTable.getColumns().addAll(companyName, stockIndex, boughtPrice,actualPrice ,change, changePercent,numberOfShares,totalValueOfShares);
        mousePressed();
        VBox overviewBox = new VBox();
        overviewBox.setSpacing(5);
        overviewBox.setPadding(new Insets(10,10,10,10));
        overviewBox.getChildren().addAll(overviewLabel, overviewTable);

        return overviewBox;
    }

    private void mousePressed(){
        overviewTable.setRowFactory( tv -> {
            TableRow<StockShare> row = new TableRow<>();
            row.setOnMouseClicked( event -> {
                if(event.getClickCount() == 2 && (!row.isEmpty())){
                    StockShare selectedStock = overviewTable.getSelectionModel().getSelectedItem();
                    setUpDetails(selectedStock);
                }
            });
            return row;
        });
    }

    private void setUpDetails(StockShare selectedStock) {
        DetailsViewController detailsViewController = new DetailsViewController(selectedStock);
        detailsViewController.setUpDetails();
    }
}
