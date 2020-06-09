// Welcome.java

package io.quicktype;

import com.fasterxml.jackson.annotation.*;

public class Welcome {
    private String table;
    private String currency;
    private String code;
    private Rate[] rates;

    @JsonProperty("table")
    public String getTable() { return table; }
    @JsonProperty("table")
    public void setTable(String value) { this.table = value; }

    @JsonProperty("currency")
    public String getCurrency() { return currency; }
    @JsonProperty("currency")
    public void setCurrency(String value) { this.currency = value; }

    @JsonProperty("code")
    public String getCode() { return code; }
    @JsonProperty("code")
    public void setCode(String value) { this.code = value; }

    @JsonProperty("rates")
    public Rate[] getRates() { return rates; }
    @JsonProperty("rates")
    public void setRates(Rate[] value) { this.rates = value; }
}