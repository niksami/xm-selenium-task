package org.example.pages;

public class StockDetails {

    private String spreadAsLow = "";
    private String minMaxTradeSize = "";
    private String marginPercentage = "";
    private String longSwapValue = "";
    private String shortSwapValue = "";
    private String limitLevels = "";

    public StockDetails(String spreadAsLow, String minMaxTradeSize, String marginPercentage, String longSwapValue, String shortSwapValue, String limitLevels) {
        this.spreadAsLow = spreadAsLow;
        this.minMaxTradeSize = minMaxTradeSize;
        this.marginPercentage = marginPercentage;
        this.longSwapValue = longSwapValue;
        this.shortSwapValue = shortSwapValue;
        this.limitLevels = limitLevels;
    }

    public String getSpreadAsLow() {
        return spreadAsLow;
    }

    public void setSpreadAsLow(String spreadAsLow) {
        this.spreadAsLow = spreadAsLow;
    }

    public String getMinMaxTradeSize() {
        return minMaxTradeSize;
    }

    public void setMinMaxTradeSize(String minMaxTradeSize) {
        this.minMaxTradeSize = minMaxTradeSize;
    }

    public String getMarginPercentage() {
        return marginPercentage;
    }

    public void setMarginPercentage(String marginPercentage) {
        this.marginPercentage = marginPercentage;
    }

    public String getLongSwapValue() {
        return longSwapValue;
    }

    public void setLongSwapValue(String longSwapValue) {
        this.longSwapValue = longSwapValue;
    }

    public String getShortSwapValue() {
        return shortSwapValue;
    }

    public void setShortSwapValue(String shortSwapValue) {
        this.shortSwapValue = shortSwapValue;
    }

    public String getLimitLevels() {
        return limitLevels;
    }

    public void setLimitLevels(String limitLevels) {
        this.limitLevels = limitLevels;
    }

}
