package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

public class UserProfile {
    private ObservableList<StockShare> ownedSharesList = FXCollections.observableArrayList();
    private String name;
    private String surname;
    private double cash;
    private double totalWalletValue;

    public UserProfile(double cash, StockShare... stockShare) {
        this.cash = cash;
        Collections.addAll(this.ownedSharesList, stockShare);
    }

    public double getCash() {
        return cash;
    }

    public double getTotalWalletValue() {
        double ownedSharesValue = 0;
        for (StockShare stock: ownedSharesList) {
            ownedSharesValue += stock.getTotalValueOfShares();
        }
        return totalWalletValue;
    }
}
