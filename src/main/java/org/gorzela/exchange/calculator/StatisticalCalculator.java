package org.gorzela.exchange.calculator;

import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.springframework.stereotype.Component;

@Component
public class StatisticalCalculator {

    public double calculateMean(AlgorithmVersion algorithmVersion, double[] values) {

        StatisticalSummary statistic = StatisticsFactory.getStatistic(algorithmVersion, values);
        return statistic.getMean();
    }

    public double calculateStandardDeviation(AlgorithmVersion algorithmVersion, double[] values) {

        StatisticalSummary statistic = StatisticsFactory.getStatistic(algorithmVersion, values);
        return statistic.getStandardDeviation();
    }
}
