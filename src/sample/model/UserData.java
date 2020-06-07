package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;

public class UserData {
    private Stocks sharesList;
    private Stocks ownedSharesList;
    private String name;
    private String surname;
    private double cash;
    private double totalWalletValue;

    public UserData(String name, String surname, double cash, Stocks sharesList) {
        this.name = name;
        this.surname = surname;
        this.cash = cash;
        this.ownedSharesList = new Stocks();
        this.sharesList = sharesList;
    }

    public Stocks getOwnedSharesList() {
        return ownedSharesList;
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

    public StockShare buyStockShare(StockShare stockShare, int amount) {
        double operationValue = stockShare.getActualPrice() * amount;
        StockShare stockShareToBuy = sharesList.getStockShare(stockShare);
        if (operationValue <= getCash()){
            System.out.println("Buying " + stockShareToBuy.getStockName());
            System.out.println("Cash before operation: " + getCash());

            setCash(getCash() - operationValue);
            stockShareToBuy.setNumberOfShares(stockShareToBuy.getNumberOfShares() + amount);
            stockShareToBuy.setBoughtPrice(stockShareToBuy.getActualPrice());
            this.ownedSharesList.addStock(stockShareToBuy);

            System.out.println(stockShareToBuy.getStockName() + " bought for " + operationValue);
            System.out.println("Cash after operation: " + getCash());
            System.out.println("Number of shares after operation: " + stockShareToBuy.getNumberOfShares());
        }

        return stockShareToBuy;
    }

    public StockShare sellStockShare(StockShare stockShare, int amount) {
        double operationValue = stockShare.getActualPrice() * amount;
        StockShare stockShareToSell = sharesList.getStockShare(stockShare);
        if (amount <= stockShare.getNumberOfShares()) {
            System.out.println("Selling " + stockShareToSell.getStockName());
            System.out.println("Cash before operation: " + getCash());

            setCash(getCash() + operationValue);
            stockShareToSell.setNumberOfShares(stockShareToSell.getNumberOfShares() - amount);
            if(stockShareToSell.getNumberOfShares() == 0) {
//                stockShareToSell.setBoughtPrice(0);
                this.ownedSharesList.removeStock(stockShareToSell);
            }

            System.out.println(stockShareToSell.getStockName() + " sold for " + operationValue);
            System.out.println("Cash after operation: " + getCash());
            System.out.println("Number of shares after operation: " + stockShareToSell.getNumberOfShares());
        }

        return stockShareToSell;
    }
}
