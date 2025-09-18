This is an experiment on limits of refactoring based on https://github.com/izabelagorzela/ExchangeRates.

Original description:

The application is dedicated for exchange rate downloading from Api NBP (http://api.nbp.pl/) and performing statistical operations on them. The application demands three parameters: currency code (for example USD), date from and date to in format RRRR-MM-DD (standard ISO 8601).

The application uses the lombok library. IDE then requires lombok plugin. 

The fourth parameter for starting the application is mandatory. Possible values are "-c" and "-custom" for custom algorithm and "-a" and "-apache" for Apache library.

Example usage: java -jar exchangerates-1.0-SNAPSHOT.jar USD 2018-10-01 2018-10-04 -c
 
