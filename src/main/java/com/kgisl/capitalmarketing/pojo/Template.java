package com.kgisl.capitalmarketing.pojo;

import java.math.BigDecimal;
import java.sql.Date;

public class Template {
    
    private int stockId;
   
    private String symbol;
   
    private String companyName;
   
    private BigDecimal currentprice;
   
    private Date lastUpdate;
    

    public Template(int stockId, String symbol, String companyName, BigDecimal currentprice, Date last) {
        this.stockId = stockId;
        this.symbol = symbol;
        this.companyName = companyName;
        this.currentprice = currentprice;
        this.lastUpdate = last;
    }

    public int getStockId() {
        return this.stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getCurrentprice() {
        return this.currentprice;
    }

    public void setCurrentprice(BigDecimal currentprice) {
        this.currentprice = currentprice;
    }

    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "{" +
            " stockId='" + getStockId() + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", currentprice='" + getCurrentprice() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            "}";
    }

}

