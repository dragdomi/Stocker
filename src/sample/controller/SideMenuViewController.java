package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


/**
 * view used as a navigation menu for the app
 * @author Dominik Drag
 */
public class SideMenuViewController {
    private MainViewController mainViewController;

    /**
     * @param mainViewController view controller to be set as a main view controller known by this class
     */
    public void setMainViewController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }

    /**
     * sets up side menu view
     * @return returns node with view
     */
    public VBox loadSideMenu() {
        VBox sideMenu = new VBox();

        int buttonsPrefWidth = 80;
        int buttonsPrefHeight = 40;
        sideMenu.setPadding(new Insets(10,10,10,10));
        sideMenu.setSpacing(10);

        Button overviewButton = new Button("Overview");
        overviewButton.setPrefWidth(buttonsPrefWidth);
        overviewButton.setPrefHeight(buttonsPrefHeight);
        overviewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Overwiew view should appear");
            }
        });

        Button addButton = new Button("Add");
        addButton.setPrefWidth(buttonsPrefWidth);
        addButton.setPrefHeight(buttonsPrefHeight);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Add view should appear");
            }
        });

        Button profileButton = new Button("Profile");
        profileButton.setPrefWidth(buttonsPrefWidth);
        profileButton.setPrefHeight(buttonsPrefHeight);
        profileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Profile view should appear");
            }
        });

        Button aboutUsButton = new Button("About us");
        aboutUsButton.setPrefWidth(buttonsPrefWidth);
        aboutUsButton.setPrefHeight(buttonsPrefHeight);
        aboutUsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("About us view should appar");
            }
        });

        sideMenu.getChildren().addAll(overviewButton, addButton, profileButton, aboutUsButton);
        return sideMenu;
    }
}
