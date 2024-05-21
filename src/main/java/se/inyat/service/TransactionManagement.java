package se.inyat.service;

import se.inyat.domain.entity.Cryptocurrency;
import se.inyat.domain.entity.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionManagement {
    //user calls from our application

    Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description);

    Transaction createWithdrawalTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description);

    //returnType
    List<Transaction> getTransactionsByWalletId(String walletId);
//Define more as needed
}