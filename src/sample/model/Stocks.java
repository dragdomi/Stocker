package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Stocks class for table view
 */
public class Stocks {
    /**
     * Atribute of observable list to table view
     */
    public ObservableList<StockShare> stocksList = FXCollections.observableArrayList();

    /**
     * Constructor of stock share class
     * @param stockShare
     */
    public Stocks(StockShare... stockShare) {
        Collections.addAll(this.stocksList, stockShare);
    }

    /**
     * Method that adds stock to list
     * @param stock
     */
    public void addStock(StockShare stock) {
        this.stocksList.add(stock);
    }

    /**
     * Method that adds stock to collection
     * @param stocksList
     */
    public void addStocks(ObservableList<StockShare> stocksList) {
        for (StockShare stock : stocksList) {
            Collections.addAll(this.stocksList, stock);
        }
    }

    /**
     * Method that removes stock from list
     * @param stock
     */
    public void removeStock(StockShare stock) {
        this.stocksList.remove(stock);
    }

    /**
     * Returns stock list to table view
     * @return stocksList
     */
    public ObservableList getStocksList() {
        return this.stocksList;
    }

    /**
     * Return stocks total value to user data
     * @return stocksValue
     */
    public double getStocksTotalValue() {
        double stocksValue = 0;
        for(StockShare stock : stocksList) {
            stocksValue += stock.getTotalValueOfShares();
            System.out.println(stocksValue);
        }
        return stocksValue;
    }

    /**
     * Gets the stock share to get
     * @param stockShareToGet
     * @return null
     */
    public StockShare getStockShare(StockShare stockShareToGet) {
        for (StockShare stockShare: stocksList) {
            if (stockShare == stockShareToGet) {
                return stockShare;
            }
        }
        return null;
    }

    /**
     * Method that is calculating actual price (simulation)
     */
    public void calculateActualPrice(){

        for(StockShare stock: stocksList){
            double random = ThreadLocalRandom.current().nextDouble(-15,+15);
            random = (double) Math.round(random*100) / 100;

            double newPrice = stock.getActualPrice()*(1 + random / 100);
            newPrice = (double) Math.round(newPrice*100)/100;
            if(newPrice > stock.getMaxValue()){
                stock.setMaxValue(newPrice);
            } else if (newPrice < stock.getMinValue()){
                stock.setMinValue(newPrice);
            }

            System.out.println(stock.getStockName() + " actual price: " + stock.getActualPrice());
            System.out.println(stock.getStockName() + " max price: " +stock.getMaxValue());
            System.out.println(stock.getStockName() + " min price: " +stock.getMinValue());
            System.out.println();

            stock.setActualPrice(newPrice);
            stock.setChange(stock.getBoughtPrice()+newPrice);
            stock.setChangePercent((stock.getBoughtPrice()+newPrice)/100);
            stock.addPriceToHistory(newPrice);
        }
    }

}