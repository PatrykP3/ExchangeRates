package org.gorzela.exchange.parameters;

import lombok.Getter;
import org.gorzela.exchange.calculator.AlgorithmVersion;
import org.springframework.context.annotation.Configuration;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Getter
@Command(name = "java -jar exchangerates", footer = "Copyright (c) 2018 by Izabela Gorzela", description = "Displays currency statistics. Data is read from NBP public API.")
public class NbpCliParameters {

    @Option(names = {"-h", "--help"}, help = true, description = "display this help message")
    private boolean helpRequested;

    @Parameters(index = "0", arity = "1", description = "currency code for calculation", paramLabel = "CURRENCY_CODE")
    private String currencyCode;

    @Parameters(index = "1", arity = "1", description = "start date of currency data", paramLabel = "DATE_FROM")
    private String dateFrom;

    @Parameters(index = "2", arity = "1", description = "end date of currency data", paramLabel = "DATE_TO")
    private String dateTo;

    @Option(names = {"-m", "-my", "-myalghoritm"}, arity = "0", description = "to use my statistics implementation, must be at the end")
    private String alghoritmVersion;

    public AlgorithmVersion getAlghoritmVersion() {
        if(alghoritmVersion != null) {
            return AlgorithmVersion.MY_ALGORITHM;
        }
        return AlgorithmVersion.APACHE_ALGORITHM;
    }
}
