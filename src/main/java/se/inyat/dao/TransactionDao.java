package se.inyat.dao;

import se.inyat.domain.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDao {
    Transaction createTransaction(Transaction transaction);
    Optional<Transaction> findById(String id);
    List<Transaction> findTransactionsByWalletId(String walletId);

}
