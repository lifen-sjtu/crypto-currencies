package crypto.services;

import crypto.models.CryptoCurrency;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

// following example here: https://www.callicoder.com/spring-5-reactive-webclient-webtestclient-examples/
@Service
public class CoinMarketCapService {
    private static final String COIN_MARKET_CAP_API_BASE_URL = "https://api.coinmarketcap.com/v1";
    private static final String USER_AGENT = "Spring 5 WebClient";

    private final WebClient webClient;

    public CoinMarketCapService() {
        this.webClient = WebClient.builder()
                .baseUrl(COIN_MARKET_CAP_API_BASE_URL)
                .build();
    }

    public Flux<CryptoCurrency> getTopCryptoCurrenies(int topN) {
        return webClient.get().uri("/ticker/?start=0&limit={topN}", topN)
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(CryptoCurrency.class));
    }
}
