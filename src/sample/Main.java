package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.controller.MainViewController;
import sample.controller.SideMenuViewController;
import sample.controller.TableViewController;


public class Main extends Application {
    private MainViewController mainViewController = new MainViewController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainViewController.setMainStage(primaryStage);
        mainViewController.setupMainScene();

    }

}

        