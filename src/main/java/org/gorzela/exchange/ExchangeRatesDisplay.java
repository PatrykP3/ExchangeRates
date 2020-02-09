package org.gorzela.exchange;

import lombok.extern.slf4j.Slf4j;
import org.gorzela.exchange.calculator.AlgorithmVersion;
import org.gorzela.exchange.calculator.StatisticalCalculator;
import org.gorzela.exchange.nbpapi.NbpApiReader;
import org.gorzela.exchange.nbpapi.entity.NbpOneCurrencyRatesResponse;
import org.gorzela.exchange.parameters.NbpCliParameters;
import org.gorzela.exchange.parameters.NbpCliParametersProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class ExchangeRatesDisplay implements CommandLineRunner {

    @Autowired
    private NbpCliParametersProvider nbpCliParametersProvider;

    @Autowired
    private NbpApiReader nbpApiReader;

    @Autowired
    private StatisticalCalculator calculator;

    @Override
    public void run(String[] args) {

        log.info("Application is running...");

        if(!nbpCliParametersProvider.getOptionalNbpCliParameters().isPresent()) {
            return;
        }

        NbpCliParameters params = nbpCliParametersProvider.getOptionalNbpCliParameters().get();

        Optional<NbpOneCurrencyRatesResponse> chargeData = nbpApiReader.getData(params.getCurrencyCode(), params.getDateFrom(), params.getDateTo());

        chargeData.ifPresent(cd -> showResult(params.getAlghoritmVersion(), calculate(params.getAlghoritmVersion(), cd.extractAsks(), cd.extractBids())));
    }

    private CalculationResult calculate(AlgorithmVersion algorithmVersion, double[] bids, double[] asks) {

        double arithmeticMean = calculator.calculateMean(algorithmVersion, bids);
        double standardDeviation = calculator.calculateStandardDeviation(algorithmVersion, asks);

        return new CalculationResult(arithmeticMean, standardDeviation);
    }

    private void showResult(AlgorithmVersion algorithmVersion, CalculationResult result) {

        System.out.format("Calculation performed with %s.%n",algorithmVersion.getAlghorithmName());
        System.out.format("Purchase average: %.4f%n", result.getMean());
        System.out.format("Standard deviation %.4f%n", result.getDeviation());
    }
}
