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

    public void addStocks(ObservableList<StockShare> stocksList) {
        for (StockShare stock : stocksList) {
            Collections.addAll(this.stocksList, stock);
        }
    }

    public void removeStock(StockShare stock) {
        this.stocksList.remove(stock);
    }

    public ObservableList getStocksList() {
        return this.stocksList;
    }

    public double getStocksTotalValue() {
        double stocksValue = 0;
        for(StockShare stock : stocksList) {
            stocksValue += stock.getTotalValueOfShares();
        }
        return stocksValue;
    }

    public StockShare getStockShare(StockShare stockShareToGet) {
        for (StockShare stockShare: stocksList) {
            if (stockShare == stockShareToGet) {
                return stockShare;
            }
        }
        return null;
    }


}
