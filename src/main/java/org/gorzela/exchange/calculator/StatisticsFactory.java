package org.gorzela.exchange.calculator;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.gorzela.exchange.statistics.CustomStatistics;

import static org.gorzela.exchange.calculator.AlgorithmVersion.MY_ALGORITHM;

public class StatisticsFactory {

    public static StatisticalSummary getStatistic(AlgorithmVersion algorithmVersion, double[] values) {

        if(algorithmVersion == MY_ALGORITHM) {
            return new CustomStatistics(values);
        }
        else {
            return new DescriptiveStatistics(values);
        }
    }
}
