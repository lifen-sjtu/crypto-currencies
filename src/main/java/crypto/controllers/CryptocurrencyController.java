package crypto.controllers;

import crypto.models.CryptoCurrency;
import crypto.services.CoinMarketCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CryptocurrencyController {

    @Autowired
    private CoinMarketCapService coinMarketCapService;
    @RequestMapping("/crypto")
    public Flux<CryptoCurrency> getTopN(@RequestParam(value="topN", defaultValue="10") int topN) {

        return coinMarketCapService.getTopCryptoCurrenies(topN);
    }
}
