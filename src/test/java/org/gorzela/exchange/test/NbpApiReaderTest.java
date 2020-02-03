package org.gorzela.exchange.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.ArrayList;
import java.util.Optional;

import org.gorzela.exchange.nbpapi.NbpApiReader;
import org.gorzela.exchange.nbpapi.entity.NbpResponse;
import org.gorzela.exchange.nbpapi.entity.Rate;
import org.gorzela.exchange.statistics.CustomStatistics;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@RestClientTest(NbpApiReader.class)
@ComponentScan("org.gorzela.exchange")
public class NbpApiReaderTest {

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private NbpApiReader nbpClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws JsonProcessingException {

        ArrayList<Rate> rates = new ArrayList<Rate>();
        rates.add(new Rate(0,0));
        rates.add(new Rate(1,1));

        NbpResponse response = new NbpResponse(rates);

        String responseString = objectMapper.writeValueAsString(response);

        this.server.expect(requestTo("http://api.nbp.pl/api/exchangerates/rates/c/2018-10-10/2018-10-10/USD")).andRespond(withSuccess(responseString, MediaType.APPLICATION_JSON));
    }

    @Test
    public void correctResponseTest() throws JsonProcessingException {

        Optional<NbpResponse> response = this.nbpClient.getData("2018-10-10",  "2018-10-10", "USD");
        assertThat(response.get().extractAsks().length == 2);

        CustomStatistics s = new CustomStatistics(response.get().extractAsks());
        assertThat(s.getMean() == 0.5);
    }
}