package com.sujith.stockprofit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.sujith.stockprofit.model.StockInfo;

class StockProfitCalculatorTest {

  @Test
  public void getBestTransaction_WhenHaveProfit() {
    List<String[]> allData = new ArrayList<>();
    //Date	      Open	      High	    Low	       Close	   Adj Close	Volume
    String[] data1 = new String[]{"2023-01-01", "10", "15", "8", "9", "9", "70425000"};
    allData.add(data1);
    String[] data2 = new String[]{"2023-01-02", "10", "20", "9", "9", "9", "80416500"};
    allData.add(data2);
    StockInfo stockInfo = StockProfitCalculator.getBestTransaction(2023, allData);
    assertEquals(12, stockInfo.getProfit());
  }

  @Test
  public void getBestTransaction_WhenHaveNoProfit_InYear() {
    List<String[]> allData = new ArrayList<>();
    //Date	      Open	      High	    Low	       Close	   Adj Close	Volume
    String[] data1 = new String[]{"2023-01-03", "10", "15", "8", "9", "9", "70425000"};
    allData.add(data1);
    String[] data2 = new String[]{"2023-01-02", "10", "20", "16", "9", "9", "80416500"};
    allData.add(data2);
    String[] data3 = new String[]{"2024-01-02", "10", "30", "25", "9", "9", "80416500"};
    allData.add(data3);
    StockInfo stockInfo = StockProfitCalculator.getBestTransaction(2023, allData);
    assertEquals(0, stockInfo.getProfit());
  }

  @Test
  public void getBestTransaction_WhenHaveOnlyRecordInAnYear() {
    List<String[]> allData = new ArrayList<>();
    //Date	      Open	      High	    Low	       Close	   Adj Close	Volume
    String[] data1 = new String[]{"2023-01-03", "10", "15", "8", "9", "9", "70425000"};
    allData.add(data1);
    String[] data2 = new String[]{"2023-01-02", "10", "20", "16", "9", "9", "80416500"};
    allData.add(data2);
    String[] data3 = new String[]{"2024-01-02", "10", "30", "25", "9", "9", "80416500"};
    allData.add(data3);
    StockInfo stockInfo = StockProfitCalculator.getBestTransaction(2024, allData);
    assertEquals(0, stockInfo.getProfit());
  }

  @Test
  public void getBestTransaction_WhenHaveNoProfit() {
    List<String[]> allData = new ArrayList<>();
    //Date	      Open	      High	    Low	       Close	   Adj Close	Volume
    String[] data1 = new String[]{"2023-01-01", "12", "15", "12", "12", "12", "70425000"};
    allData.add(data1);
    String[] data2 = new String[]{"2023-01-02", "12", "12", "12", "12", "12", "80416500"};
    allData.add(data2);
    StockInfo stockInfo = StockProfitCalculator.getBestTransaction(2023, allData);
    assertEquals(0, stockInfo.getProfit());
  }


}
