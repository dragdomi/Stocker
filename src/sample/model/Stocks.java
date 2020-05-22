package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;

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
}
