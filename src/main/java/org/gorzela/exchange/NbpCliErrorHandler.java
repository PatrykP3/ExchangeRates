package org.gorzela.exchange;

import org.gorzela.exchange.nbpapi.NbpApiResponseErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class NbpCliErrorHandler implements NbpApiResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {

        if (clientHttpResponse.getStatusCode() != HttpStatus.OK) {

            return true;
        }
        return false;
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

        System.out.println(clientHttpResponse.getStatusText());
        System.out.println("For help start the program with -h or --help parameter");
        if(clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
            System.out.println("Today's data may not be available");
        }
    }
}
