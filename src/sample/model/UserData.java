package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;

public class UserData {
    private Stocks ownedSharesList;
    private String name;
    private String surname;
    private double cash;
    private double totalWalletValue;

    public UserData(String name, String surname, double cash, Stocks stocks) {
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.ownedSharesList = stocks;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getCash() {
        return cash;
    }

    public double getTotalWalletValue() {
        return ownedSharesList.getStocksTotalValue();
    }
}
