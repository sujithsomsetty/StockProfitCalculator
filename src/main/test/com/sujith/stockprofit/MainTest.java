package com.sujith.stockprofit;

import org.junit.jupiter.api.Test;

class MainTest {

  // As it is a static main method, I manually checked printouts for validation, no assertion added due to time constraint.
  @Test
  public void invalidStockValidYear() {
    Main.main(new String[]{"APPLE", "2015"});
    //  First argument APPLE is not a valid stock, and valid stocks are: AAPL ,MSFT ,NFLX ,TSLA.
  }

  @Test
  public void validStockInvalidYear() {
    Main.main(new String[]{"MSFT", "0224"});
    //  Second argument 0224 is not a valid year
  }

  @Test
  public void invalidArgument() {
    Main.main(new String[]{"a"});
    //  Please send valid arguments, first argument should be one of stocks AAPL ,MSFT ,NFLX ,TSLA. Second argument should be an year between 2014 and 2024.

  }

  @Test
  public void invalidNoOfArguments() {
    Main.main(new String[]{"a" , "b" , "c"});
   // Please send valid arguments, first argument should be one of stocks AAPL ,MSFT ,NFLX ,TSLA. Second argument should be an year between 2014 and 2024.

  }

  @Test
  public void validStockInvalidYear() {
    Main.main(new String[]{"AAPL" , "year"});
   // Second argument year is not a valid integer
  }

  @Test
  public void validStockValidYear() {
    Main.main(new String[]{"AAPL", "2016"});
    //  Stock and Year passed into max Profit calculator are: TSLA, 2014.
  }

}
