package com.sujith.stockprofit.model;

import java.time.LocalDate;

public class StockInfo {

  private LocalDate buyDate;
  private double buyPrice;
  private LocalDate sellDate;
  private double sellPrice;
  private double profit;

  public StockInfo() {
  }

  public StockInfo(LocalDate buyDate, double buyPrice, LocalDate sellDate, double sellPrice, double profit) {
    this.buyDate = buyDate;
    this.buyPrice = buyPrice;
    this.sellDate = sellDate;
    this.sellPrice = sellPrice;
    this.profit = profit;
  }

  public LocalDate getBuyDate() {
    return buyDate;
  }

  public void setBuyDate(LocalDate buyDate) {
    this.buyDate = buyDate;
  }

  public double getBuyPrice() {
    return buyPrice;
  }

  public void setBuyPrice(double buyPrice) {
    this.buyPrice = buyPrice;
  }

  public LocalDate getSellDate() {
    return sellDate;
  }

  public void setSellDate(LocalDate sellDate) {
    this.sellDate = sellDate;
  }

  public double getSellPrice() {
    return sellPrice;
  }

  public void setSellPrice(double sellPrice) {
    this.sellPrice = sellPrice;
  }

  public double getProfit() {
    return profit;
  }

  public void setProfit(double profit) {
    this.profit = profit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StockInfo)) {
      return false;
    }

    StockInfo stockInfo = (StockInfo) o;

    if (Double.compare(stockInfo.getBuyPrice(), getBuyPrice()) != 0) {
      return false;
    }
    if (Double.compare(stockInfo.getSellPrice(), getSellPrice()) != 0) {
      return false;
    }
    if (Double.compare(stockInfo.getProfit(), getProfit()) != 0) {
      return false;
    }
    if (getBuyDate() != null ? !getBuyDate().equals(stockInfo.getBuyDate()) : stockInfo.getBuyDate() != null) {
      return false;
    }
    return getSellDate() != null ? getSellDate().equals(stockInfo.getSellDate()) : stockInfo.getSellDate() == null;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = getBuyDate() != null ? getBuyDate().hashCode() : 0;
    temp = Double.doubleToLongBits(getBuyPrice());
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (getSellDate() != null ? getSellDate().hashCode() : 0);
    temp = Double.doubleToLongBits(getSellPrice());
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(getProfit());
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "StockInfo{" +
        "buyDate=" + buyDate +
        ", buyPrice=" + buyPrice +
        ", sellDate=" + sellDate +
        ", sellPrice=" + sellPrice +
        ", profit=" + profit +
        '}';
  }
}
