package sample.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class StockShare {
    private SimpleStringProperty stockName;
    private SimpleStringProperty stockIndex;
    private SimpleDoubleProperty boughtPrice;
    private SimpleDoubleProperty actualPrice;
    private SimpleIntegerProperty numberOfShares;
    private SimpleDoubleProperty change;
    private SimpleDoubleProperty changePercent;
    private SimpleDoubleProperty totalValueOfShares;
    private SimpleDoubleProperty minValue = new SimpleDoubleProperty(0);
    private SimpleDoubleProperty maxValue = new SimpleDoubleProperty(0);


    public StockShare(String stockName, String stockIndex, double boughtPrice, int numberOfShares) {
        this.stockName = new SimpleStringProperty(stockName);
        this.stockIndex = new SimpleStringProperty(stockIndex);
        this.boughtPrice = new SimpleDoubleProperty(boughtPrice);
        this.actualPrice = new SimpleDoubleProperty(boughtPrice);
        this.change = new SimpleDoubleProperty(boughtPrice - boughtPrice);
        this.changePercent = new SimpleDoubleProperty((boughtPrice - boughtPrice) / 100);
        this.numberOfShares = new SimpleIntegerProperty(numberOfShares);
        this.totalValueOfShares = new SimpleDoubleProperty(numberOfShares * boughtPrice);
        this.minValue = new SimpleDoubleProperty(boughtPrice);
        this.maxValue = new SimpleDoubleProperty(boughtPrice);
    }

    public String getStockName() {
        return this.stockName.get();
    }

    public void setStockName(String stockName) {
        this.stockName = new SimpleStringProperty(stockName);
    }

    public String getStockIndex() {
        return this.stockIndex.get();
    }

    public void setStockIndex(String stockIndex) {
        this.stockIndex = new SimpleStringProperty(stockIndex);
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

    public void setChange(double change) {
        this.change = new SimpleDoubleProperty(change);
    }

    public double getChangePercent() {
        return this.change.get();
    }

    public void setChangePercent(double change) {
        this.change = new SimpleDoubleProperty((change) / 100);
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

    public double getMinValue() {
        return this.minValue.get();
    }

    public void setMinValue(double minValue) {
        this.minValue = new SimpleDoubleProperty(minValue);
    }

    public double getMaxValue() {
        return this.maxValue.get();
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = new SimpleDoubleProperty(maxValue);
    }

}