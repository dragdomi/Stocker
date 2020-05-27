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
                    setUpDetails();
                }
            });
            return row;
        });
    }

    private void setUpDetails(){

        Stage stockDetails = new Stage();
        stockDetails.setTitle("Company Details");
        VBox mainVBox = new VBox();

        mainVBox.getChildren().addAll(setUpName(),setUpChart(),setUpPrice());


        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(mainVBox);

        Scene detailsScene = new Scene(mainLayout, 800, 500);
        stockDetails.setScene(detailsScene);
        stockDetails.show();
    }

    private HBox setUpName(){
        HBox companyDetails = new HBox();

        Label companyName = new Label("CD Project");
        //companyName.setMinHeight(40);
        companyName.setPrefHeight(40);
        companyName.setPadding(new Insets(0,10,0,0));
        Label sharePrice = new Label("3.62");
        sharePrice.setPrefHeight(40);
        companyDetails.getChildren().addAll(companyName,sharePrice);
        companyDetails.setPadding(new Insets(10,10,10,10));

        return companyDetails;
    }

    private LineChart setUpChart(){

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        yAxis.setLabel("Price");

        LineChart<Number,Number> lineChart = new LineChart<Number, Number>(xAxis,yAxis);

        lineChart.setTitle("Stock Details");
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data(1,23));
        series.getData().add(new XYChart.Data(2,15));
        series.getData().add(new XYChart.Data(3,16));
        series.getData().add(new XYChart.Data(4,17));
        series.getData().add(new XYChart.Data(5,54));
        series.getData().add(new XYChart.Data(6,64));
        series.getData().add(new XYChart.Data(7,43));
        series.getData().add(new XYChart.Data(8,54));
        series.getData().add(new XYChart.Data(9,23));
        series.getData().add(new XYChart.Data(10,43));

        series.setName("Stock Monitor");

        lineChart.getData().add(series);
        lineChart.setPadding(new Insets(10,10,10,10));

        return lineChart;
    }

    private VBox setUpPrice(){
        VBox vBox = new VBox();
        HBox minPrice = new HBox();
        HBox maxPrice = new HBox();

        Label minPriceLabel = new Label("Minimum Price: ");
        Label maxPriceLabel = new Label("Maximum Price: ");
        Label testPrice = new Label("3.20");

        minPrice.setPadding(new Insets(10,10,10,10));
        maxPrice.setPadding(new Insets(10,10,10,10));

        minPrice.getChildren().addAll(minPriceLabel,testPrice);
        maxPrice.getChildren().addAll(maxPriceLabel,testPrice);

        vBox.getChildren().addAll(minPrice,maxPrice);
        return vBox;
    }

}
