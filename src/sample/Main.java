package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.StockShare;
import sample.view.OverviewTableView;

public class Main extends Application {
    Stage window;
    private TableView<StockShare> overviewTable =  new TableView<StockShare>();
    final ObservableList<StockShare> listOfStocks = FXCollections.observableArrayList(
            new StockShare("CDR","HujWieJaki",10 , 10),
            new StockShare("11bit","HujWieJaki",10 , 10),
            new StockShare("PKNOrlen","HujWieJaki",10 , 10)
    );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        Label yourSharesLabel = new Label("Your Stock Shares");

        overviewTable.setEditable(true);

        TableColumn companyName = new TableColumn("Company Name");
        TableColumn stockIndex = new TableColumn("Stock Index");
        TableColumn sharePrice = new TableColumn("Share Price");
        TableColumn numberOfShares = new TableColumn("Number of Shares");
        TableColumn totalValue = new TableColumn("Total Value");

        companyName.setCellValueFactory( new PropertyValueFactory<StockShare, String>("companyName"));

        companyName.setPrefWidth(116);
        stockIndex.setPrefWidth(116);
        sharePrice.setPrefWidth(116);
        numberOfShares.setPrefWidth(116);
        totalValue.setPrefWidth(116);


        overviewTable.setItems(listOfStocks);
        overviewTable.getColumns().addAll(companyName,stockIndex,sharePrice,numberOfShares, totalValue);


        VBox tableViewBox = new VBox();
        tableViewBox.setSpacing(5);
        tableViewBox.setPadding(new Insets(10,10,10,10));
        tableViewBox.getChildren().addAll(yourSharesLabel, overviewTable);


        BorderPane overviewLayout = new BorderPane();
        //overviewLayout.setPadding(new Insets(6,6,6,6));
        overviewLayout.setCenter(tableViewBox);
        Scene overviewScene = new Scene(overviewLayout, 600, 400);

        window.setTitle("Stocker");
        window.setScene(overviewScene);
        window.show();

    }

}




