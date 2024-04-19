package com.sujith.stockprofit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.sujith.stockprofit.model.StockInfo;

public class StockProfitCalculator {

  public StockInfo mainProfit(String stockName, int year) {

    CSVReader reader = null;
    try {
      reader = new CSVReaderBuilder(new FileReader("C:\\stocks\\" + stockName + ".CSV"))
          .withSkipLines(1) // TO Skip Header
          .build();

    } catch (FileNotFoundException e) {
      System.out.println("System error file not found for given stock: " + stockName);
      return new StockInfo();
    }

    List<String[]> allData = null;
    try {
      allData = reader.readAll();
    } catch (IOException | CsvException e) {
      System.out.println("System error while reading file: " + stockName);
      return new StockInfo();
    }
    return getBestTransaction(year, allData);

  }

  static StockInfo getBestTransaction(int year, List<String[]> allData) {
    StockInfo bestTransaction = new StockInfo(null, 0, null, 0, 0);
    double buyPrice = 0; // 10
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
    LocalDate buyDate = null;
    double sellPrice = 0;
    LocalDate sellDate = null;
    double maxProfit = 0;
    for (String[] data : allData) {
      String date = data[0];
      String[] dateYear = date.split("-");
      int currentYear = Integer.parseInt(dateYear[0]);

      double lowPrice = Double.parseDouble(data[3]);
      double highPrice = Double.parseDouble(data[2]);

      if (currentYear == year) {
        if (buyPrice == 0) {
          buyPrice = lowPrice;
          buyDate = LocalDate.parse(date, formatter);

        }
        if (buyPrice > lowPrice) {
          buyPrice = lowPrice;
          buyDate = LocalDate.parse(date, formatter);
        }
        if (sellPrice == 0) {
          sellPrice = highPrice;
          sellDate = LocalDate.parse(date, formatter);
        }
        if (sellPrice < highPrice) {
          sellPrice = highPrice;
          sellDate = LocalDate.parse(date, formatter);
        }
        if (sellDate.isAfter(buyDate)) {
          maxProfit = sellPrice - buyPrice;
          bestTransaction = new StockInfo(buyDate, buyPrice, sellDate, sellPrice, maxProfit);
        }
      }
    }
    return bestTransaction;
  }
}
