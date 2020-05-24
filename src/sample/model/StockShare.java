package sample.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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
        }
