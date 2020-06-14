package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * view used as a navigation menu for the app
 * @author Dominik Drag, Arystydes Krukar
 */
public class SideMenuViewController {
    private MainViewController mainViewController;
    private int buttonsPrefWidth = 80;
    private int buttonsPrefHeight = 40;

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

        sideMenu.setPadding(new Insets(10,10,10,10));
        sideMenu.setSpacing(10);

        Button overviewButton = new Button("Overview");
        setUpButton(overviewButton);
        overviewButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainViewController.setCenter(mainViewController.overviewBox);
            }
        });

        Button addButton = new Button("My Stocks");
        setUpButton(addButton);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainViewController.setCenter(mainViewController.myStonksViewBox);
            }
        });

        Button profileButton = new Button("Profile");
        setUpButton(profileButton);
        profileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                mainViewController.setCenter(mainViewController.profileViewBox);
            }
        });

        Button aboutUsButton = new Button("About us");
        setUpButton(aboutUsButton);
        aboutUsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainViewController.setCenter(mainViewController.aboutUsBox);
            }
        });

        sideMenu.getChildren().addAll(overviewButton, addButton, profileButton, aboutUsButton);
        return sideMenu;
    }

    private void setUpButton(Button button) {
        button.setPrefHeight(buttonsPrefHeight);
        button.setPrefWidth(buttonsPrefWidth);
    }
}