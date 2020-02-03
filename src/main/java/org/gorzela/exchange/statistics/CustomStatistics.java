package org.gorzela.exchange.statistics;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Arrays;

import org.apache.commons.math3.stat.descriptive.StatisticalSummary;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomStatistics implements StatisticalSummary {

    private double[] values;

    @Override
    public double getMean() {
        return getSum() / getN();
    }

    @Override
    public double getVariance() {

        double mean = getMean();
        double numerator = Arrays.stream(values).map(((price) -> pow(price - mean, 2))).sum();

        return numerator / (getN() - 1);
    }

    @Override
    public double getStandardDeviation() {

       if (getN() == 1) {
           return 0;
       }
       else {
           return sqrt(getVariance());
       }
    }

    @Override
    public double getMax() {
        return Arrays.stream(values).max().getAsDouble();
    }

    @Override
    public double getMin() {
        return Arrays.stream(values).min().getAsDouble();
    }

    @Override
    public long getN() {
        return values.length;
    }

    @Override
    public double getSum() {
        return Arrays.stream(values).sum();
    }
}