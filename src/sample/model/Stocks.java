package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Random;

public class Stocks {
    private ObservableList<StockShare> stocksList = FXCollections.observableArrayList();

    public Stocks(StockShare... stockShare) {
        Collections.addAll(this.stocksList, stockShare);
    }

    public void addStock(StockShare stock) {
        this.stocksList.add(stock);
    }

    public void removeStock(StockShare stock) {
        this.stocksList.remove(stock);
    }

    public ObservableList getStocksList() {
        return this.stocksList;
    }

    public void simulateStockSharesPrices() {
        for (StockShare stock: stocksList) {
            Random r = new Random();
            double randomValue = 0.0 + (50.0 - 0.0) * r.nextDouble();
            stock.setSharePrice(stock.getSharePrice() + randomValue);
        }
    }
}
