package org.gorzela.exchange.calculator;

import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.gorzela.exchange.statistics.StatisticAlgorithmSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticalCalculator {

    @Autowired
    StatisticsProvider statisticsProvider;

    public double calculateMean(AlgorithmVersion algorithmVersion, double[] values) {

        StatisticAlgorithmSupport statistic = statisticsProvider.getStatistic(algorithmVersion);
        statistic.setValues(values);
        return statistic.getMean();
    }

    public double calculateStandardDeviation(AlgorithmVersion algorithmVersion, double[] values) {

        StatisticAlgorithmSupport statistic = statisticsProvider.getStatistic(algorithmVersion);
        statistic.setValues(values);
        return statistic.getStandardDeviation();
    }
}
