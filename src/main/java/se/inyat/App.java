package se.inyat;

import se.inyat.config.AppConfig;
import se.inyat.dao.TransactionDao;
import se.inyat.dao.WalletDao;
import se.inyat.dao.impl.TransactionDaoImpl;
import se.inyat.dao.impl.WalletDaoImpl;
import se.inyat.model.CryptoCurrency;
import se.inyat.model.Transaction;
import se.inyat.model.Wallet;
import se.inyat.service.TransactionManagement;
import se.inyat.service.WalletManagement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.inyat.service.impl.TransactionManagementImpl;
import se.inyat.service.impl.WalletManagementImpl;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        WalletDao walletDao = new WalletDaoImpl();
        TransactionDao transactionDao = new TransactionDaoImpl();

        WalletManagement walletManagement = new WalletManagementImpl(walletDao);
        TransactionManagement transactionManagement = new TransactionManagementImpl();


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        walletManagement = context.getBean(WalletManagement.class);
        transactionManagement = context.getBean(TransactionManagement.class);

        Wallet myWallet = walletManagement.create("my-first-wallet");
        Transaction depositTransactionForBTC = transactionManagement.createDepositTransaction(
                myWallet.getId(),
                CryptoCurrency.BTC,
                new BigDecimal(1),
                "Test");

        System.out.println(walletManagement.getById(myWallet.getId()));

        Transaction depositTransactionForETH = transactionManagement.createDepositTransaction(
                myWallet.getId(),
                CryptoCurrency.ETH,
                new BigDecimal(10),
                "Test");

        System.out.println(walletManagement.getById(myWallet.getId()));

        Transaction depositTransactionForBTC2 = transactionManagement.createDepositTransaction(
                myWallet.getId(),
                CryptoCurrency.BTC,
                new BigDecimal(2),
                "Test");

        System.out.println(walletManagement.getById(myWallet.getId()));


    }
}