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
public class NbpResponse {

    private ArrayList<Rate> rates;

    public double[] extractBids() {

        double[] bids = rates.stream().mapToDouble((rate) -> rate.getBid()).toArray();

        return bids;
      }

    public double[] extractAsks() {

        double[] asks = rates.stream().mapToDouble((rate) -> rate.getAsk()).toArray();

        return asks;
    }
}
