package org.gorzela.exchange.calculator;

import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class AlgorithmVersionProvider {

    public AlgorithmVersion getAlgorithmVersion(String algorithmVersionParameter) {

        AlgorithmVersion algorithmVersion = Arrays.stream(AlgorithmVersion.values())
                .filter(av -> av.getAlgorithmNames().contains(algorithmVersionParameter))
                .findFirst()
                .orElse(AlgorithmVersion.MY_ALGORITHM);

        return algorithmVersion;
    }

}
