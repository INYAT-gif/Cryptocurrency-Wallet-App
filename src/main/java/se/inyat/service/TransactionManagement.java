package se.inyat.service;

import se.inyat.model.CryptoCurrency;
import se.inyat.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionManagement {
    public Transaction createDepositTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description);

    public Transaction createWithdrawTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description);
    List<Transaction> getTransactionsByWalletId(String walletId);
}
