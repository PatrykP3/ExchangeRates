package org.gorzela.exchange.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.gorzela.exchange.calculator.AlgorithmVersion;
import org.springframework.stereotype.Component;

@Component
public class Math3Statistics extends DescriptiveStatistics implements StatisticAlgorithmSupport {

    @Override
    public boolean supports(AlgorithmVersion algorithmVersion) {
        return false;
    }

    @Override
    public void setValues(double[] values) {
        this.setValues(values);
    }
}
