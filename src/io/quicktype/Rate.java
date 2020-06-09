// Rate.java

package io.quicktype;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class Rate {
    private String no;
    private LocalDate effectiveDate;
    private double mid;

    @JsonProperty("no")
    public String getNo() { return no; }
    @JsonProperty("no")
    public void setNo(String value) { this.no = value; }

    @JsonProperty("effectiveDate")
    public LocalDate getEffectiveDate() { return effectiveDate; }
    @JsonProperty("effectiveDate")
    public void setEffectiveDate(LocalDate value) { this.effectiveDate = value; }

    @JsonProperty("mid")
    public double getMid() { return mid; }
    @JsonProperty("mid")
    public void setMid(double value) { this.mid = value; }
}