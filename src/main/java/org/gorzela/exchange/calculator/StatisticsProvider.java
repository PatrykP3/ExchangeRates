package org.gorzela.exchange.calculator;

import java.util.List;
import org.gorzela.exchange.statistics.StatisticAlgorithmSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
