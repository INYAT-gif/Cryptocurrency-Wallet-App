package se.inyat;

import se.inyat.config.AppConfig;
import se.inyat.model.CryptoCurrency;
import se.inyat.model.Transaction;
import se.inyat.model.Wallet;
import se.inyat.service.TransactionManagement;
import se.inyat.service.WalletManagement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        //WalletDao walletDao = new WalletDaoImpl();
        //TransactionDao transactionDao = new TransactionDaoImpl();

        //WalletManagement walletManagement = new WalletManagementImpl(walletDao);
        //TransactionManagement transactionManagement = new TransactionManagementImpl(walletDao, transactionDao);


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WalletManagement walletManagement = context.getBean(WalletManagement.class);
        TransactionManagement transactionManagement = context.getBean(TransactionManagement.class);

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