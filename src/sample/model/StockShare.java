package sample.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StockShare {
    private SimpleStringProperty stockName;
    private SimpleStringProperty stockSector;
    private SimpleDoubleProperty sharePrice;
    private SimpleIntegerProperty numberOfShares;
    private SimpleDoubleProperty totalValueOfShares;

    public StockShare(String stockName, String stockSector, double sharePrice, int numberOfShares){
        this.stockName = new SimpleStringProperty(stockName);
        this.stockSector = new SimpleStringProperty(stockSector);
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

            public String getStockSector() {
                return this.stockSector.get();
            }

            public void setStockSector(String stockSector){
                this.stockSector = new SimpleStringProperty(stockSector);
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
