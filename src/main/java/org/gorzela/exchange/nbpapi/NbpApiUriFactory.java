package org.gorzela.exchange.nbpapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Component
public class NbpApiUriFactory {

    @Autowired
    private NbpApiConfiguration nbpApiConfiguration;

    public URI getUri(String pathPart1, String pathPart2, String pathPart3) {

        UriComponents uc = UriComponentsBuilder.newInstance()
                .scheme(nbpApiConfiguration.getProtocol())
                .host(nbpApiConfiguration.getHost())
                .path(nbpApiConfiguration.getPath())
                .build()
                .expand(pathPart1, pathPart2, pathPart3)
                .encode();
        return uc.toUri();
    }
}
