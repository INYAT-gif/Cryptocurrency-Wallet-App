package se.inyat.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String type;//deposit, withdrawal, ...
    private BigDecimal amount;
    private String walletId;
    private Cryptocurrency cryptocurrencySymbol;
    private String description;
    private LocalDateTime timestamp;

    public Transaction(String deposit, BigDecimal amount, String walletId, String name) {
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public Cryptocurrency getCryptocurrencySymbol() {
        return cryptocurrencySymbol;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transaction(String type, BigDecimal amount, String walletId, Cryptocurrency cryptocurrencySymbol) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Amount must be grater than zero");
        //no need id + just initiate timestamp
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", walletId='" + walletId + '\'' +
                ", cryptocurrencySymbol=" + cryptocurrencySymbol +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    //to featch data from database
    public Transaction(String id, String type, BigDecimal amount, String walletId, Cryptocurrency cryptocurrencySymbol, String description, LocalDateTime timestamp) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        this.description = description;
        this.timestamp = timestamp;
    }
}
