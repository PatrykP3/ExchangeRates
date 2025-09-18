package org.gorzela.exchange.statistics;

import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.gorzela.exchange.calculator.AlgorithmVersion;

public interface StatisticAlgorithmSupport extends StatisticalSummary {

    boolean supports(AlgorithmVersion algorithmVersion);

    void setValues(double[] values);
}
