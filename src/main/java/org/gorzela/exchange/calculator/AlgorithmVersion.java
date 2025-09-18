package org.gorzela.exchange.calculator;

import java.util.List;
import lombok.Getter;

import static org.gorzela.exchange.common.Constants.APACHE_ALGORITHM_PARAMETERS;
import static org.gorzela.exchange.common.Constants.CUSTOM_ALGORITHM_PARAMETERS;

@Getter
public enum AlgorithmVersion {

    MY_ALGORITHM(CUSTOM_ALGORITHM_PARAMETERS, "my implementation"),
    APACHE_ALGORITHM(APACHE_ALGORITHM_PARAMETERS, "Apache Commons Math implementation");

    AlgorithmVersion(List<String> algorithmNames, String longName) {
        this.algorithmNames = algorithmNames;
        this.longName = longName;
    }

    private List<String> algorithmNames;

    private String longName;
}
