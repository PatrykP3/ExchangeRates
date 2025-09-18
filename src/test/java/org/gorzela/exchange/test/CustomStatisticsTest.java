package org.gorzela.exchange.test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.gorzela.exchange.statistics.CustomStatistics;
import org.junit.Test;

public class CustomStatisticsTest {

//    @Test
//    public void arithmeticMeanSmallValuesTest() {
//
//        double[] bids = {0.0073, 0.0023};
//        CustomStatistics customStatistics = new CustomStatistics(bids);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(bids);
//        assertEquals(descriptiveStatistics.getMean(), customStatistics.getMean(), 0.0000001);
//    }
//
//    @Test
//    public void arithmeticMeanOneValueTest() {
//
//        double[] bids = {3.7273};
//        CustomStatistics customStatistics = new CustomStatistics(bids);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(bids);
//        assertEquals(descriptiveStatistics.getMean(), customStatistics.getMean(), 0);
//    }
//
//    @Test
//    public void arithmeticMeanTwoValuesTest() {
//
//        double[] bids = {3.7273, 3.7626};
//        CustomStatistics customStatistics = new CustomStatistics(bids);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(bids);
//        assertEquals(descriptiveStatistics.getMean(), customStatistics.getMean(), 0);
//    }
//
//    @Test
//    public void arithmeticMeanFiveValuesTest() {
//
//        double[] bids = {3.7273,3.7258,3.7626, 3.4258,3.7626 };
//        CustomStatistics customStatistics = new CustomStatistics(bids);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(bids);
//        assertEquals(descriptiveStatistics.getMean(), customStatistics.getMean(), 0.0000001);
//    }
//
//    @Test
//    public void arithmeticMeanTenValuesTest() {
//
//        double[] bids = {3.7273, 3.7258, 3.7626, 3.7273, 3.7258, 3.7626, 3.4258, 3.7626, 3.7626, 3.4258};
//        CustomStatistics customStatistics = new CustomStatistics(bids);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(bids);
//        assertEquals(descriptiveStatistics.getMean(), customStatistics.getMean(), 0.0000001);
//    }
//
//    @Test
//    public void StandardDeviationSmallValuesTest() {
//
//        double[] asks = {0.0073, 0.0023};
//        CustomStatistics customStatistics = new CustomStatistics(asks);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(asks);
//        assertEquals(descriptiveStatistics.getStandardDeviation(), customStatistics.getStandardDeviation(), 0.0000001);
//    }
//
//    @Test
//    public void StandardDeviationOneValueTest() {
//
//        double[] asks = {3.7273};
//        CustomStatistics customStatistics = new CustomStatistics(asks);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(asks);
//        assertEquals(descriptiveStatistics.getStandardDeviation(), customStatistics.getStandardDeviation(), 0);
//    }
//
//    @Test
//    public void StandardDeviationTwoValuesTest() {
//
//        double[] asks = {3.7273, 3.7626};
//        CustomStatistics customStatistics = new CustomStatistics(asks);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(asks);
//        assertEquals(descriptiveStatistics.getStandardDeviation(), customStatistics.getStandardDeviation(), 0);
//    }
//
//    @Test
//    public void StandardDeviationFiveValuesTest() {
//
//        double[] asks = {3.7273,3.7258,3.7626, 3.4258,3.7626};
//        CustomStatistics customStatistics = new CustomStatistics(asks);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(asks);
//        assertEquals(descriptiveStatistics.getStandardDeviation(), customStatistics.getStandardDeviation(), 0.0000001);
//    }
//
//    @Test
//    public void StandardDeviationTenValuesTest() {
//
//        double[] asks = {3.7273, 3.7258, 3.7626, 3.7273, 3.7258, 3.7626, 3.4258, 3.7626, 3.7626, 3.4258};
//        CustomStatistics customStatistics = new CustomStatistics(asks);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(asks);
//        assertEquals(descriptiveStatistics.getStandardDeviation(), customStatistics.getStandardDeviation(), 0.0000001);
//    }
//
//    // simple, redundant test used for development
//    @Test
//    public void VarianceTest() {
//
//        double[] asks = {1, 2, 1};
//        CustomStatistics customStatistics = new CustomStatistics(asks);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(asks);
//        double x = descriptiveStatistics.getVariance();
//        double v = customStatistics.getVariance();
//        assertEquals(descriptiveStatistics.getMin(), customStatistics.getMin(), 0);
//    }
//
//    @Test
//    public void MinValueTest() {
//        double[] asks = {3, 5, 6};
//        CustomStatistics customStatistics = new CustomStatistics(asks);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(asks);
//        assertEquals(descriptiveStatistics.getMin(), customStatistics.getMin(), 0);
//    }
//
//    @Test
//    public void MaxValueTest() {
//        double[] asks = {3, 5, 6};
//        CustomStatistics customStatistics = new CustomStatistics(asks);
//        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(asks);
//        assertEquals(descriptiveStatistics.getMax(), customStatistics.getMax(), 0);
//    }
}

