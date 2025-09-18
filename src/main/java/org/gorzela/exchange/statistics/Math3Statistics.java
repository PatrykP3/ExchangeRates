package org.gorzela.exchange.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.gorzela.exchange.calculator.AlgorithmVersion;
import org.springframework.stereotype.Component;

import static org.gorzela.exchange.calculator.AlgorithmVersion.APACHE_ALGORITHM;

@Component
public class Math3Statistics extends DescriptiveStatistics implements StatisticAlgorithmSupport {

    @Override
    public boolean supports(AlgorithmVersion algorithmVersion) {
        return algorithmVersion.equals(APACHE_ALGORITHM);
    }

    @Override
    public void setValues(double[] values) {
        this.setValues(values);
    }
}
