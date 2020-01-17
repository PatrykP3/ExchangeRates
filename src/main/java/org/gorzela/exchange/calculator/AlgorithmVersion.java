package org.gorzela.exchange.calculator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AlgorithmVersion {

    MY_ALGORITHM("custom alghorithm"),
    APACHE_ALGORITHM("Apache Commons alghorithm");

    private String alghorithmName;
}
