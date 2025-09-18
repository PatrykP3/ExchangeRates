package org.gorzela.exchange.calculator;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.gorzela.exchange.common.Constants.APACHE_ALGORITHM_PARAMETERS;
import static org.gorzela.exchange.common.Constants.CUSTOM_ALGORITHM_PARAMETERS;

@Getter
public enum AlgorithmVersion {

    MY_ALGORITHM(CUSTOM_ALGORITHM_PARAMETERS),
    APACHE_ALGORITHM(APACHE_ALGORITHM_PARAMETERS);

    AlgorithmVersion(List<String> algorithmNames) {
        this.algorithmNames = algorithmNames;
    }

    private List<String> algorithmNames;
}
