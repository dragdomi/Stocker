package sample.controller;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.model.StockShare;
import sample.model.Stocks;
import sample.model.UserData;

/**
 * Main view controller
 * Used to store other view controllers and manage scenes and layout of the app.
 * @author Dominik Drag, Arystydes Krukar
 */
public class MainViewController {
    private Stage mainStage;

    private BorderPane mainLayout = new BorderPane();

    public final Stocks stocks = new Stocks(
            new StockShare("CDR", "Gaming", 346, 0),
            new StockShare("PKOBP", "Banking", 22, 0),
            new StockShare("PKN", "Fuels", 346, 0)
    );

    private UserData userData = new UserData("Marian", "Chudy", 1000, stocks);

    private OverviewViewController overviewViewController = new OverviewViewController();
    private AddViewController addViewController = new AddViewController();
    private SideMenuViewController sideMenuViewController = new SideMenuViewController();
    private AboutUsViewController aboutUsViewController = new AboutUsViewController();
    private ProfileViewController profileViewController = new ProfileViewController();

    public VBox overviewBox;
    public VBox addViewBox;
    public VBox sideMenu;
    public HBox aboutUsBox;
    public VBox profileViewBox;

    /**
     * @param stage stage to be set as a main stage
     */
    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }

    /**
     * sets up the main scene of the app
     */
    public void setupMainScene() {
        sideMenuViewController.setMainViewController(this);
        overviewViewController.setUserData(userData);
        overviewViewController.setStocks(stocks);
        profileViewController.setUserDataSource(userData);


        overviewBox = overviewViewController.loadOverviewView();
        addViewBox = addViewController.loadAddView();
        sideMenu = sideMenuViewController.loadSideMenu();
        aboutUsBox = aboutUsViewController.loadAboutUsView();
        profileViewBox = profileViewController.loadProfileView();

        mainLayout.setCenter(overviewBox);
        mainLayout.setLeft(sideMenuViewController.loadSideMenu());

        Scene mainScene = new Scene(mainLayout, 1030, 400);

        mainStage.setTitle("Stocker");
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    /**
     * @param node node to be set in the center of the layout
     */
    public void setCenter(Node node) {
        mainLayout.setCenter(node);
    }
}
