package se.inyat.dao;

import se.inyat.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDao {
    Transaction createTransaction(Transaction transaction);
    Optional<Transaction> findById(String transactionId);
    List<Transaction> findTransactionsByWalletId(String walletId);

}
