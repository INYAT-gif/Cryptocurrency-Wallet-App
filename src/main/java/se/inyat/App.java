package se.inyat;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.inyat.config.AppConfig;
import se.inyat.domain.entity.Cryptocurrency;
import se.inyat.domain.entity.Transaction;
import se.inyat.domain.entity.Wallet;
import se.inyat.service.TransactionManagement;
import se.inyat.service.WalletManagement;


import java.math.BigDecimal;

public class App {

    public static void main(String[] args ) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WalletManagement walletManagement = context.getBean(WalletManagement.class);
        TransactionManagement transactionManagement = context.getBean(TransactionManagement.class);
        Wallet wallet = walletManagement.create("My Wallet");

        Transaction depositTransactionBTC = transactionManagement.createDepositTransaction(
                wallet.getId(),
                Cryptocurrency.BTC,
                new BigDecimal(10),
                "Test transaction");

        Transaction depositTransactionETH = transactionManagement.createDepositTransaction(
                wallet.getId(),
                Cryptocurrency.ETH,
                new BigDecimal(5),
                "Test transaction");

        System.out.println(walletManagement.getById(wallet.getId()));

    }
}