package com.sujith.stockprofit.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public enum Stock {

  Apple("AAPL"),
  Microsoft("MSFT"),
  Netflix("NFLX"),
  Tesla("TSLA");

  @Getter
  private String value;

  Stock(String value) {
    this.value = value;
  }
}
