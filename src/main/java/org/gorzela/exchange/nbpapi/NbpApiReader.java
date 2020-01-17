package org.gorzela.exchange.nbpapi;

import org.gorzela.exchange.nbpapi.entity.NbpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;


@Component
public class NbpApiReader {

    private final RestTemplate restTemplate;

    @Autowired
    private NbpApiUriFactory nbpApiUriFactory;

    @Autowired
    public NbpApiReader(RestTemplateBuilder rtb, NbpApiResponseErrorHandler errorHandler) {
        this.restTemplate = rtb.build();
        this.restTemplate.setErrorHandler(errorHandler);
    }


    public Optional<NbpResponse> getData(String pathPart1, String pathPart2, String pathPart3) {

        URI uri = nbpApiUriFactory.getUri(pathPart1, pathPart2, pathPart3);
        ResponseEntity<NbpResponse> entity;

        try {
            entity = restTemplate.getForEntity(uri, NbpResponse.class);

        } catch (RestClientException ex) {

            return Optional.empty();
        }

        if (entity.getStatusCode() != HttpStatus.OK) {

            return Optional.empty();
        }

        return Optional.ofNullable(entity.getBody());
    }
}