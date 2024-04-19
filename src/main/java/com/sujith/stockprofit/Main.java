package com.sujith.stockprofit;

import com.sujith.stockprofit.model.Stock;
import com.sujith.stockprofit.model.StockInfo;


public class Main {

  public static void main(String[] args) {

    if (args.length != 2) {
      System.out.println("Please send valid arguments, first argument should be one of stocks "
          + Stock.Apple.getValue() + " ,"
          + Stock.Microsoft.getValue() + " ,"
          + Stock.Netflix.getValue() + " ,"
          + Stock.Tesla.getValue() + ". Second argument should be an year between 2014 and 2024.");
      for (int i = 0; i < args.length; i++) {
        System.out.printf("Your entered command Line Argument %d is %s%n", i, args[i]);
      }
      return;
    }
    if(isFirstArgumentValid(args[0]) && isSecondArgumentValid(args[1]) ) {
      System.out.println("Stock and Year passed into max Profit calculator are: "+ args[0] + ", " +args[1] );
      StockProfitCalculator stockProfitCalculator = new StockProfitCalculator();
      StockInfo stockInfo = stockProfitCalculator.mainProfit(args[0], Integer.parseInt(args[1]));
      if(stockInfo.getProfit() > 0) {
        System.out.println("Maximum profit data for stock: "+ args[0] + " in year: "+args[1]+ " is: " +stockInfo.toString());
      }
    }
  }

  private static boolean isSecondArgumentValid(String argument) {
    try {
    int year = Integer.parseInt(argument);
    if (year < 2014 || year > 2024) {
      System.out.println(" Second argument " + argument + " is not a valid year");
      return false;
    } else {
     return true;
    }
  } catch (NumberFormatException e) {
    System.out.println(" Second argument " + argument + " is not a valid integer");
  }
    return false;
  }

  static boolean isFirstArgumentValid(String stockName) {
    if (stockName.length() != 4) {
      System.out.println(" First argument " + stockName + " is not a valid stock, "
          + "and valid stocks are: " + Stock.Apple.getValue() + " ,"
          + Stock.Microsoft.getValue() + " ,"
          + Stock.Netflix.getValue() + " ,"
          + Stock.Tesla.getValue() + ".");
      return false;
    }
    for (Stock s : Stock.values()) {
       if(s.getValue().equalsIgnoreCase(stockName)) {
         return true;
       }
    }
    return false;
  }

}
