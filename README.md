# Sujith

## File placement

1. Create stocks directory in C Drive.
2. Copy stock csv files into stocks directory. 

If you place in different directory, please update that info in StockProfitCalculator.java class 

reader = new CSVReader(new FileReader("C:\\stocks\\"+stockName+".CSV"));

## Build/Installation

1. Maven 3, JDK 17

Build: mvn clean

mvn compile

cd src/main/java

java com/sujith/stockprofit/Main.java

