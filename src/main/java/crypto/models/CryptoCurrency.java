package crypto.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CryptoCurrency {
    private String id;

    private String name;

    private String symbol;

    private Long rank;

    @JsonProperty("market_cap_usd")
    private Float marketCap;

    @JsonProperty("total_supply")
    private Float totalSupply;

    @JsonProperty("price_usd")
    private Float priceUsd;


    public String getName() {
        return name;
    }

    public Long getRank() {
        return rank;
    }

    public String getId() {
        return id;
    }

    public Float getPriceUsd() {
        return priceUsd;
    }

    public Float getMarketCap() {
        return marketCap;
    }

    public Float getTotalSupply() {
        return totalSupply;
    }

    public String getSymbol() {
        return symbol;
    }
}
