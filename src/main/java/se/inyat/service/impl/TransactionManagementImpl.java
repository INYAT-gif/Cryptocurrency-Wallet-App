package se.inyat.service.impl;

import se.inyat.dao.TransactionDao;
import se.inyat.dao.WalletDao;
import se.inyat.model.CryptoCurrency;
import se.inyat.model.Transaction;
import se.inyat.service.TransactionManagement;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionManagementImpl implements TransactionManagement {
    private WalletDao walletdao;
    private TransactionDao transactionDao;

    @Override
    public Transaction createDepositTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {
        return null;
    }

    @Override
    public Transaction createWithdrawTransaction(String walletId, CryptoCurrency cryptoCurrency, BigDecimal amount, String description) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(String walletId) {

        List<Transaction> transactions = transactionDao.findTransactionsByWalletId(walletId);
        return transactions.stream()
                .filter(transaction -> transaction.getType().equals("withdraw"))
                .collect(Collectors.toList());
    }
}
