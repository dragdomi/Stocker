package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

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

//    Timer timer = new Timer();
//
//    public void task(){
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                calculateActualPrice();
//            }
//        };
//
//        timer.scheduleAtFixedRate(task,5000,5000);
//    }



}