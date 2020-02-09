package org.gorzela.exchange.nbpapi.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpOneCurrencyRatesResponse {

    private ArrayList<NbpOneCurrencyRate> rates;

    public double[] extractBids() {

        double[] bids = rates.stream().mapToDouble(NbpOneCurrencyRate::getBid).toArray();

        return bids;
      }

    public double[] extractAsks() {

        double[] asks = rates.stream().mapToDouble(NbpOneCurrencyRate::getAsk).toArray();

        return asks;
    }
}
