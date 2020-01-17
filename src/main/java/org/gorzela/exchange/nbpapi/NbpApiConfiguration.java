package org.gorzela.exchange.nbpapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("nbpapi")
@Setter
@Getter
public class NbpApiConfiguration {

    private String protocol;
    private String host;
    private String path;
}
