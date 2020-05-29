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

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getTotalWalletValue() {
        return ownedSharesList.getStocksTotalValue();
    }

    public void buyStockShare(StockShare stockShare, int amount) {
        double operationValue = stockShare.getActualPrice() * amount;
        if (operationValue <= getCash()){
            System.out.println("Buying " + stockShare.getStockName());
            System.out.println("Cash before operation: " + getCash());

            ownedSharesList.addStock(stockShare);
            setCash(getCash() - operationValue);
            if (stockShare.getNumberOfShares() < 1) {
                ownedSharesList.addStock(stockShare);
            }

            System.out.println(stockShare.getStockName() + " bought for " + operationValue);
            System.out.println("Cash after operation: " + getCash());
        }
    }

    public void sellStockShare(StockShare stockShare, int amount) {
        double operationValue = stockShare.getActualPrice() * amount;
        StockShare ownedStockShareToSell = ownedSharesList.getStockShare(stockShare);
        if (amount <= stockShare.getNumberOfShares()) {
            System.out.println("Selling " + ownedStockShareToSell.getStockName());
            System.out.println("Cash before operation: " + getCash());

            ownedStockShareToSell.setNumberOfShares(ownedStockShareToSell.getNumberOfShares() - amount);
            setCash(getCash() + operationValue);
            if (ownedStockShareToSell.getNumberOfShares() < 1) {
                ownedSharesList.removeStock(ownedStockShareToSell);
            }

            System.out.println(ownedStockShareToSell.getStockName() + " sold for " + operationValue);
            System.out.println("Cash after operation: " + getCash());
        }
    }
}
