package org.gorzela.exchange.statistics;

import java.util.Arrays;
import org.gorzela.exchange.calculator.AlgorithmVersion;
import org.springframework.stereotype.Component;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static org.gorzela.exchange.calculator.AlgorithmVersion.MY_ALGORITHM;

@Component
public class CustomStatistics implements StatisticAlgorithmSupport {

    private double[] values;

    @Override
    public boolean supports(AlgorithmVersion algorithmVersion) {
        return algorithmVersion.equals(MY_ALGORITHM);
    }

    @Override
    public void setValues(double[] values) {
        this.values = values;
    }

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

        return getN() == 1 ? 0 : sqrt(getVariance());
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