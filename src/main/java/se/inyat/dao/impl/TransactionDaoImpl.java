package se.inyat.dao.impl;

import org.springframework.stereotype.Component;
import se.inyat.dao.TransactionDao;
import se.inyat.domain.entity.Transaction;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TransactionDaoImpl implements TransactionDao {
    //instantiate list for storage
    private List<Transaction> storage;
    public TransactionDaoImpl() {

        this.storage = new ArrayList<>();
    }


    @Override
    public Transaction createTransaction(Transaction transaction) {
        storage.add(transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(String transactionId) {
        return storage.stream()
                .filter(transaction -> transaction.getId().equals(transactionId))
                .findFirst();
    }

    @Override
    public List<Transaction> findTransactionsByWalletId(String walletId) {
        return storage.stream()
                .filter(transaction -> transaction.getWalletId().equals(walletId))
                .collect(Collectors.toList());
        //return list of transaction with same wallet id
    }

}