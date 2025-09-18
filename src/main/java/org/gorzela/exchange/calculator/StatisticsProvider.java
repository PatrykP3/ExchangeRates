package org.gorzela.exchange.calculator;

import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.gorzela.exchange.statistics.StatisticAlgorithmSupport;
import org.gorzela.exchange.statistics.CustomStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.gorzela.exchange.calculator.AlgorithmVersion.MY_ALGORITHM;

@Component
public class StatisticsProvider {

    @Autowired
    private List<StatisticAlgorithmSupport> statistics;

    public StatisticAlgorithmSupport getStatistic(AlgorithmVersion algorithmVersion) {

        return statistics.stream()
                .filter(statistic -> statistic.supports(algorithmVersion))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No statistic found for algorithm version: " + algorithmVersion));
    }
}
