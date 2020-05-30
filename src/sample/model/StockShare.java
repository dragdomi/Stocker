package sample.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class StockShare {
    private SimpleStringProperty stockName;
    private SimpleStringProperty stockSector;
    private SimpleDoubleProperty boughtPrice;
    private SimpleDoubleProperty actualPrice;
    private SimpleIntegerProperty numberOfShares;
    private SimpleDoubleProperty change;
    private SimpleDoubleProperty changePercent;
    private SimpleDoubleProperty totalValueOfShares;

    public StockShare(String stockName, String stockSector, double boughtPrice, int numberOfShares) {
        this.stockName = new SimpleStringProperty(stockName);
        this.stockSector = new SimpleStringProperty(stockSector);
        this.boughtPrice = new SimpleDoubleProperty(boughtPrice);
        this.actualPrice = new SimpleDoubleProperty(boughtPrice);
        this.change = new SimpleDoubleProperty(boughtPrice - boughtPrice);
        this.changePercent = new SimpleDoubleProperty((boughtPrice - boughtPrice) / 100);
        this.numberOfShares = new SimpleIntegerProperty(numberOfShares);
        this.totalValueOfShares = new SimpleDoubleProperty(numberOfShares * boughtPrice);
    }

    public String getStockName() {
        return this.stockName.get();
    }

    public void setStockName(String stockName) {
        this.stockName = new SimpleStringProperty(stockName);
    }

    public String getStockSector() {
        return this.stockSector.get();
    }

    public void setStockSector(String stockSector) {
        this.stockSector = new SimpleStringProperty(stockSector);
    }

    public double getBoughtPrice() {
        return this.boughtPrice.get();
    }

    public void setBoughtPrice(double boughtPrice) {
        this.boughtPrice = new SimpleDoubleProperty(boughtPrice);
    }

    public double getChange() {
        return this.change.get();
    }

    public void setChange(double actualPrice, double boughtPrice) {
        this.change = new SimpleDoubleProperty(actualPrice - boughtPrice);
    }

    public double getChangePercent() {
        return this.change.get();
    }

    public void setChangePercent(double actualPrice, double boughtPrice) {
        this.change = new SimpleDoubleProperty((actualPrice - boughtPrice) / 100);
    }

    public double getActualPrice() {
        return this.actualPrice.get();
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = new SimpleDoubleProperty(actualPrice);
    }

    public int getNumberOfShares() {
        return this.numberOfShares.get();
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = new SimpleIntegerProperty(numberOfShares);
    }

    public void setTotalValueOfShares(int numberOfShares, double sharePrice) {
        this.totalValueOfShares = new SimpleDoubleProperty(numberOfShares * sharePrice);
    }

    public double getTotalValueOfShares() {
        return this.totalValueOfShares.get();
    }
}
