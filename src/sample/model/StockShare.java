package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StockShare {

   private SimpleStringProperty companyName;
   String stockIndex;
   double sharePrice;
   int numberOfShares;
   double totalValueOfShares;

    public StockShare(String companyName, String stockIndex, double sharePrice, int numberOfShares){
        this.companyName = new SimpleStringProperty(companyName);
        this.stockIndex = stockIndex;
        this.sharePrice = sharePrice;
        this.numberOfShares = numberOfShares;
        this.totalValueOfShares = this.sharePrice * this.numberOfShares;
    }

    public StringProperty companyNameProperty(){
        return this.companyName;
    }
    public String getCompanyName(){
        return this.companyName.get();
    }

    public void setCompanyName(String companyName){
        this.companyName.set(companyName);
    }

}
