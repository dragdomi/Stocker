package sample.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that provides one single stock share
 */
public class StockShare {
    private SimpleStringProperty stockName;
    private SimpleStringProperty stockIndex;
    private SimpleDoubleProperty boughtPrice;
    private SimpleDoubleProperty actualPrice;
    private SimpleDoubleProperty actualEuroPrice;
    private SimpleIntegerProperty numberOfShares;
    private SimpleDoubleProperty change;
    private SimpleDoubleProperty changePercent;
    private SimpleDoubleProperty totalValueOfShares;
    private SimpleDoubleProperty minValue = new SimpleDoubleProperty(0);
    private SimpleDoubleProperty maxValue = new SimpleDoubleProperty(0);
    private ArrayList<Double> priceHistory = new ArrayList<Double>();

    /**
     * Constructor of class StockShare
     * @param stockName  company name
     * @param stockIndex company index
     * @param actualPrice company actual price
     * @param numberOfShares company number of shares
     */
    public StockShare(String stockName, String stockIndex, double actualPrice, int numberOfShares) {
        this.stockName = new SimpleStringProperty(stockName);
        this.stockIndex = new SimpleStringProperty(stockIndex);
        this.boughtPrice = new SimpleDoubleProperty(0);
        this.actualPrice = new SimpleDoubleProperty(actualPrice);
        this.actualEuroPrice = new SimpleDoubleProperty(actualPrice*4.44);
        this.change = new SimpleDoubleProperty(0);
        this.changePercent = new SimpleDoubleProperty(0);
        this.numberOfShares = new SimpleIntegerProperty(numberOfShares);
        this.totalValueOfShares = new SimpleDoubleProperty(0);
        this.minValue = new SimpleDoubleProperty(actualPrice);
        this.maxValue = new SimpleDoubleProperty(actualPrice);
    }

    public StockShare(String stockName, String stockIndex, double boughtPrice,double actualPrice, int numberOfShares) {
        this.stockName = new SimpleStringProperty(stockName);
        this.stockIndex = new SimpleStringProperty(stockIndex);
        this.boughtPrice = new SimpleDoubleProperty(boughtPrice);
        this.actualPrice = new SimpleDoubleProperty(actualPrice);
        this.change = new SimpleDoubleProperty(0);
        this.changePercent = new SimpleDoubleProperty(0);
        this.numberOfShares = new SimpleIntegerProperty(numberOfShares);
        this.totalValueOfShares = new SimpleDoubleProperty(boughtPrice*numberOfShares);
        this.minValue = new SimpleDoubleProperty(actualPrice);
        this.maxValue = new SimpleDoubleProperty(actualPrice);
    }

    /**
     * Returs stock name
     * @return stockName.get()
     */
    public String getStockName() {
        return this.stockName.get();
    }

    /**
     * Sets stock name
     * @param stockName
     */
    public void setStockName(String stockName) {
        this.stockName = new SimpleStringProperty(stockName);
    }

    /**
     * Returns stock index
     * @return stockIndex.get()
     */
    public String getStockIndex() {
        return this.stockIndex.get();
    }

    /**
     * Sets stock index
     * @param stockIndex
     */
    public void setStockIndex(String stockIndex) {
        this.stockIndex = new SimpleStringProperty(stockIndex);
    }

    /**
     * Returns bought price
     * @return boughtPrice.get();
     */
    public double getBoughtPrice() {
        return this.boughtPrice.get();
    }

    /**
     * Sets bought price
     * @param boughtPrice
     */
    public void setBoughtPrice(double boughtPrice) {
        this.boughtPrice = new SimpleDoubleProperty(boughtPrice);
    }

    /**
     * Returns change
     * @return change.get()
     */
    public double getChange() {
        return this.change.get();
    }

    /**
     * Sets change
     * @param change
     */
    public void setChange(double change) {
        this.change = new SimpleDoubleProperty(change);
    }

    /**
     * Returns change percent
     * @return change.get()/100
     */
    public double getChangePercent() {
        return this.change.get()/100;
    }

    /**
     * Sets company change percent
     * @param change/100
     */
    public void setChangePercent(double change) {
        this.change = new SimpleDoubleProperty((change) / 100);
    }

    /**
     * Returns company actual price
     * @return actualPrice.get()
     */
    public double getActualPrice() {
        return this.actualPrice.get();
    }

    public double getActualEuroPrice() {
        return this.actualEuroPrice.get();
    }
    public void setActualEuroPrice(double actualEuroPrice) {
        this.actualEuroPrice = new SimpleDoubleProperty(actualEuroPrice);
    }

    /**
     * Sets company actual price
     * @param actualPrice
     */
    public void setActualPrice(double actualPrice) {
        this.actualPrice = new SimpleDoubleProperty(actualPrice);
    }

    /**
     * Returns company number of shares
     * @return numberOfShares.get()
     */
    public int getNumberOfShares() {
        return this.numberOfShares.get();
    }

    /**
     * Sets company number of shares
     * @param numberOfShares
     */
    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = new SimpleIntegerProperty(numberOfShares);
    }

    /**
     * Sets total value of possessing shares
     */
    public void setTotalValueOfShares() {
        this.totalValueOfShares = new SimpleDoubleProperty(getNumberOfShares() * getActualPrice());
    }

    /**
     * Returs total value of possessing shares
     * @return totalValueOfShares.get()
     */
    public double getTotalValueOfShares() {
        setTotalValueOfShares();
        return this.totalValueOfShares.get();
    }

    /**
     * Returns minimal value of company
     * @return minValue.get()
     */
    public double getMinValue() {
        return this.minValue.get();
    }

    /**
     * Sets minimal value of comapny
     * @param minValue
     */
    public void setMinValue(double minValue) {
        this.minValue = new SimpleDoubleProperty(minValue);
    }

    /**
     * Returns maximum value of comapny
     * @return maxValue.get()
     */
    public double getMaxValue() {
        return this.maxValue.get();
    }

    /**
     * Sets maximul value of company
     * @param maxValue
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = new SimpleDoubleProperty(maxValue);
    }

    /**
     * Method that add price to history price to draw chart
     * @param price
     */
    public void addPriceToHistory(double price) {
        if(this.priceHistory.size() >= 10) {
            this.priceHistory.remove(0);
        }
        this.priceHistory.add(price);
    }

    /**
     * Returs price history of the company
     * @return priceHistory
     */
    public ArrayList<Double> getPriceHistory() {
        return priceHistory;
    }
}