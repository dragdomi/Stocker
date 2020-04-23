package sample.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;


public class StockShare {

    private SimpleStringProperty stockName;
    private SimpleStringProperty stockIndex;
    private SimpleDoubleProperty sharePrice;
    private SimpleIntegerProperty numberOfShares;
    private SimpleDoubleProperty totalValueOfShares;


    public StockShare(String stockName, String stockIndex, double sharePrice, int numberOfShares){
        this.stockName = new SimpleStringProperty(stockName);
        this.stockIndex = new SimpleStringProperty(stockIndex);
        this.sharePrice = new SimpleDoubleProperty(sharePrice);
        this.numberOfShares = new SimpleIntegerProperty(numberOfShares);
        this.totalValueOfShares = new SimpleDoubleProperty(numberOfShares * sharePrice);
    }


            public String getStockName () {
                return this.stockName.get();
            }

            public void setStockName (String stockName){
                this.stockName = new SimpleStringProperty(stockName);

            }


            public String getStockIndex () {
                return this.stockIndex.get();
            }

            public void setStockIndex (String stockIndex){
                this.stockIndex = new SimpleStringProperty(stockIndex);
            }

            //  private double sharePrice;
            // private int numberOfShares;
            //private double totalValueOfShares;

            public double getSharePrice(){
                return this.sharePrice.get();
            }

            public void setSharePrice ( double sharePrice){
                this.sharePrice = new SimpleDoubleProperty(sharePrice);
            }

            public int getNumberOfShares(){
                return this.numberOfShares.get();
            }

            public void setNumberOfShares ( int numberOfShares){
                this.numberOfShares = new SimpleIntegerProperty(numberOfShares);
            }

            public void setTotalValueOfShares ( int numberOfShares, double sharePrice){
                this.totalValueOfShares = new SimpleDoubleProperty(numberOfShares * sharePrice);
            }

            public double getTotalValueOfShares () {
                return this.totalValueOfShares.get();
            }


            public void calculateCurrentSharePrice(){
                double random = ThreadLocalRandom.current().nextDouble(-10, 10);
                random = (double) Math.round(random*100)/100;

                double newCurrentPrice = this.getSharePrice() * (1 + random/100);
                newCurrentPrice = (double) Math.round(newCurrentPrice * 100)/100;

                this.setSharePrice(newCurrentPrice);
            }

        }
