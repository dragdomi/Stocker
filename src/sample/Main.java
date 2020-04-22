package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.model.StockShare;
import sample.model.Stocks;


public class Main extends Application {
    Stage window;
    private TableView<StockShare> overviewTable = new TableView<StockShare>();
    final ObservableList<StockShare> listOfStocks = FXCollections.observableArrayList(
            new StockShare("CDR", "HujWieJaki", 10, 10),
            new StockShare("11bit", "HujWieJaki", 10, 10),
            new StockShare("PKNOrlen", "HujWieJaki", 10, 10)
    );

    private TableView<StockShare> overviewTable = new TableView<StockShare>();

    private Stocks stocks = new Stocks(
            new StockShare("CDR", "HujWieJaki", 10, 10),
            new StockShare("11bit", "HujWieJaki", 10, 10),
            new StockShare("PKNOrlen", "HujWieJaki", 10, 10)
    );

    final ObservableList<StockShare> listOfStocks = stocks.getStocksList();


    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage primaryStage) throws Exception {

        public void start (Stage primaryStage) throws Exception {

            window = primaryStage;

            Label yourSharesLabel = new Label("Your Stock Shares");

            overviewTable.setEditable(true);

            TableColumn<StockShare, String> companyName = new TableColumn<>("Company Name");
            TableColumn<StockShare, String> stockIndex = new TableColumn<>("Stock Index");
            TableColumn<StockShare, Double> sharePrice = new TableColumn("Share Price");
            TableColumn<StockShare, Integer> numberOfShares = new TableColumn("Number of Shares");
            TableColumn<StockShare, Double> totalValue = new TableColumn("Total Value");


            companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
            stockIndex.setCellValueFactory(new PropertyValueFactory<>("stockIndex"));
            sharePrice.setCellValueFactory(new PropertyValueFactory<>("sharePrice"));
            numberOfShares.setCellValueFactory(new PropertyValueFactory<>("numberOfShares"));

            companyName.setCellValueFactory(new PropertyValueFactory<>("stockName"));
            stockIndex.setCellValueFactory(new PropertyValueFactory<>("stockIndex"));
            sharePrice.setCellValueFactory(new PropertyValueFactory<>("sharePrice"));
            numberOfShares.setCellValueFactory(new PropertyValueFactory<>("numberOfShares"));


            companyName.setPrefWidth(116);
            stockIndex.setPrefWidth(116);
            sharePrice.setPrefWidth(116);
            numberOfShares.setPrefWidth(116);
            totalValue.setPrefWidth(116);


            overviewTable.setItems(listOfStocks);

            overviewTable.getColumns().addAll(companyName, stockIndex, sharePrice, numberOfShares, totalValue);

            overviewTable.getColumns().addAll(companyName, stockIndex, sharePrice, numberOfShares, totalValue);


            VBox tableViewBox = new VBox();
            tableViewBox.setSpacing(5);

            tableViewBox.setPadding(new Insets(10, 10, 10, 10));
            tableViewBox.getChildren().addAll(yourSharesLabel, overviewTable, addNewCompanyToTableView(listOfStocks));

            tableViewBox.setPadding(new Insets(10, 10, 10, 10));
            tableViewBox.getChildren().addAll(yourSharesLabel, overviewTable, addNewCompanyToTableView(listOfStocks));


            BorderPane overviewLayout = new BorderPane();
            //overviewLayout.setPadding(new Insets(6,6,6,6));
            overviewLayout.setCenter(tableViewBox);
            Scene overviewScene = new Scene(overviewLayout, 600, 400);

            window.setTitle("Stocker");
            window.setScene(overviewScene);
            window.show();

        }


        HBox addNewCompanyToTableView (ObservableList listOfStocks){

            HBox addNewCompanyToTableView (ObservableList listOfStocks){

                HBox addNewCompany = new HBox();

                TextField companyName = new TextField();
                companyName.setPromptText("Company Name");


                TextField stockIndex = new TextField();
                stockIndex.setPromptText("Stock Index");

                TextField sharePrice = new TextField();
                sharePrice.setPromptText("Share Price");

                TextField numberOfShares = new TextField();
                numberOfShares.setPromptText("Number Of Shares");

                Button addButton = new Button("Add Company");
                addButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String sharePriceString;
                        String numberOfSharesString;
                        listOfStocks.add(new StockShare(
                                companyName.getText(),
                                stockIndex.getText(),
                                10,
                                10
                        ));
                        companyName.clear();
                        stockIndex.clear();
                        sharePrice.clear();
                        numberOfShares.clear();
                    }
                });

                addNewCompany.getChildren().addAll(companyName, stockIndex, sharePrice, numberOfShares, addButton);


                TextField stockIndex = new TextField();
                stockIndex.setPromptText("Stock Index");

                TextField sharePrice = new TextField();
                sharePrice.setPromptText("Share Price");

                TextField numberOfShares = new TextField();
                numberOfShares.setPromptText("Number Of Shares");

                Button addCompanyButton = new Button("Add Company");
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