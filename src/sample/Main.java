package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.controller.TableViewController;


public class Main extends Application {
    Stage window;
    TableViewController tableViewController = new TableViewController();
    VBox tableViewBox = tableViewController.loadTableView();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        BorderPane overviewLayout = new BorderPane();
        //overviewLayout.setPadding(new Insets(6,6,6,6));
        overviewLayout.setCenter(tableViewBox);
        Scene overviewScene = new Scene(overviewLayout, 800, 400);

        window.setTitle("Stocker");
        window.setScene(overviewScene);
        window.show();

    }

}

        