package sample.controller;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sample.model.StockShare;
import sample.model.Stocks;

public class ProfileViewController {

    public VBox loadProfileView() {
        VBox profileView = new VBox();
        profileView.setPadding(new Insets(10,10,10,10));
        profileView.getChildren().addAll(
                userDetails(),
                userMoney(),
                userShares(),
                userTotalWalletValue(),
                userTransactionHistory()
        );
        return profileView;
    }

    private HBox userDetails() {
        HBox userDetails = new HBox();

        setStyle(userDetails);
        userDetails.setPadding(new Insets(10,10,10,10));
        userDetails.getChildren().addAll(userDetailsVBox());

        return userDetails;
    }

    private VBox userDetailsVBox() {
        VBox userDetails = new VBox();

        Label userNameLabel = new Label("Name: ");
        Label userSurnameLabel = new Label("Surname: ");

        userNameLabel.setPadding(new Insets(0,10,10,0));
        userSurnameLabel.setPadding(new Insets(0,10,10,0));
        userDetails.getChildren().addAll(userNameLabel, userSurnameLabel);

        return userDetails;
    }

    private HBox userMoney() {
        HBox userMoney = new HBox();

        Label userMoneyLabel = new Label("Money left: ");

        setStyle(userMoney);
        userMoney.setPadding(new Insets(10,10,10,10));
        userMoney.getChildren().addAll(userMoneyLabel);

        return userMoney;
    }

    private HBox userShares() {
        HBox userShares = new HBox();

        Label sharesLabel = new Label("Shares: ");

        setStyle(userShares);
        userShares.setPadding(new Insets(10,10,10,10));
        userShares.getChildren().addAll(sharesLabel);

        return userShares;
    }

    private HBox userTotalWalletValue() {
        HBox userTotalWalletValue = new HBox();

        Label totalWalletValueLabel = new Label("Total wallet value: ");

        setStyle(userTotalWalletValue);
        userTotalWalletValue.setPadding(new Insets(10,10,10,10));
        userTotalWalletValue.getChildren().addAll(totalWalletValueLabel);

        return userTotalWalletValue;
    }

    private HBox userTransactionHistory() {
        HBox userTransactionHistory = new HBox();

        Label transactionHistoryLabel = new Label("Transaction history: ");
        Button transactionHistoryButton = new Button("View history");
        transactionHistoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Transaction history view should appar");
            }
        });

        setStyle(userTransactionHistory);
        userTransactionHistory.setPadding(new Insets(10,10,10,10));
        userTransactionHistory.getChildren().addAll(transactionHistoryLabel, transactionHistoryButton);

        return userTransactionHistory;
    }

    private VBox userTransactionHistoryVBox() {
        VBox userTransactionHistory = new VBox();



        return userTransactionHistory;
    }

    private void setStyle(HBox box) {
        box.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        box.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(1))));
    }
}
