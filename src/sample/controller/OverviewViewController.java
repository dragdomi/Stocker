package sample.controller;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import sample.model.StockShare;
import sample.model.Stocks;

public class OverviewViewController {
    private TableView<StockShare> overviewTable = new TableView<StockShare>();

    private final Stocks stocks = new Stocks(
            new StockShare("CDR", "WIG20", 346, 50),
            new StockShare("11bit", "mWIG40", 405.50, 123),
            new StockShare("PKNOrlen", "WIG30", 61.50, 30)
    );

    private final ObservableList<StockShare> listOfStocks = stocks.getStocksList();

    public VBox loadOverviewView () {
        Label overviewLabel = new Label("Overview");
        overviewTable.setEditable(true);

        TableColumn<StockShare, String> companyName = new TableColumn<>("Company Name");
        TableColumn<StockShare, String> stockIndex = new TableColumn<>("Stock Index");
        TableColumn<StockShare, Double> sharePrice = new TableColumn("Share price");
        TableColumn<StockShare, Double> change = new TableColumn("Change");
        TableColumn<StockShare, Double> changePercent = new TableColumn("Change (%)");

        companyName.setCellValueFactory(new PropertyValueFactory<>("stockName"));
        stockIndex.setCellValueFactory(new PropertyValueFactory<>("stockIndex"));
        sharePrice.setCellValueFactory(new PropertyValueFactory<>("sharePrice"));
        change.setCellValueFactory(new PropertyValueFactory<>("change"));
        changePercent.setCellValueFactory(new PropertyValueFactory<>("changePercent"));

        companyName.setPrefWidth(116);
        stockIndex.setPrefWidth(116);
        sharePrice.setPrefWidth(116);
        change.setPrefWidth(116);
        changePercent.setPrefWidth(116);

        overviewTable.setItems(listOfStocks);

        overviewTable.getColumns().addAll(companyName, stockIndex, sharePrice, change, changePercent);

        VBox overviewBox = new VBox();
        overviewBox.setSpacing(5);
        overviewBox.setPadding(new Insets(10,10,10,10));
        overviewBox.getChildren().addAll(overviewLabel, overviewTable);

        return overviewBox;
    }
}
