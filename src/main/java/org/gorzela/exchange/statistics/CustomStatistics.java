package org.gorzela.exchange.statistics;

import lombok.AllArgsConstructor;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@AllArgsConstructor
public class CustomStatistics implements StatisticalSummary {

    private double[] values;

    @Override
    public double getMean() {
        return getSum() / getN();
    }

    @Override
    public double getVariance() {

        double numerator = 0;
        double mean = getMean();

        for(double price: values) {
            numerator = numerator + (pow(price - mean,2));
        }
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
        return 0;
    }

    @Override
    public double getMin() {
        return 0;
    }

    @Override
    public long getN() {
        return values.length;
    }

    @Override
    public double getSum() {
        double sum = 0;
        for(double price: values) {

            sum = sum + price;
        }
        return sum;
    }
}