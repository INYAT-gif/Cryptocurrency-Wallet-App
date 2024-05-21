package se.inyat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.inyat.dao.TransactionDao;
import se.inyat.dao.WalletDao;
import se.inyat.domain.entity.Cryptocurrency;
import se.inyat.domain.entity.Transaction;
import se.inyat.domain.entity.Wallet;
import se.inyat.exception.WalletNotFoundException;
import se.inyat.service.TransactionManagement;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TransactionManagementImpl implements TransactionManagement {

    private WalletDao walletDao;
    private TransactionDao transactionDao;

    @Autowired
    public TransactionManagementImpl(WalletDao walletDao, TransactionDao transactionDao){
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }
    @Override
    public Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        // 1. Validate params (parameters)  //Business logic
        // 2. Check if wallet exists
        //3. Call the deposit method on the wallet object
        //4.Create transaction object
        //5. Save transaction to the storage
        if(walletId == null || cryptocurrency == null || amount == null)
            throw new IllegalArgumentException("Parameter is not valid");

        //need dependency injection at start private WalletDao.walletDao;
        Optional<Wallet> optionalWallet = walletDao.findWalletById(walletId);
        if(!optionalWallet.isPresent())throw new WalletNotFoundException("Parameter is not valid");
        //create a wallet object
        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptocurrency, amount);
        Transaction transaction = new Transaction("Deposit", amount, walletId, cryptocurrency.getName());
        transaction.setDescription(description);
        //setDescription get it from our parameters

        //save to storage by injection dependency
        //dao
        return transactionDao.createTransaction(transaction);




    }

    @Override
    public Transaction createWithdrawalTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(String walletId) {
        return null;
    }
}