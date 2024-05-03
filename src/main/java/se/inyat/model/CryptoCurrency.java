package se.inyat.model;

public enum CryptoCurrency {
    BTC("Bitcoin"),
    ETH("Ethereum"),
    USDT("Tether"),
    BNB("BNB"); // Add more currencies here
    private final String name;
    CryptoCurrency(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
