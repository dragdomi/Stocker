package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import sample.controller.MainViewController;

/**
 * @author arystydeskrukar
 * @author dominikdrag
 * @version 1.0
 */
public class Main extends Application {
    private MainViewController mainViewController = new MainViewController();

    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     * Starts the program
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainViewController.setMainStage(primaryStage);
        mainViewController.setupMainScene();
    }

}

        