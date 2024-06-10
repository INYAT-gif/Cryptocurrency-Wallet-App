# Cryptocurrency Wallet Management System (Console based app)

This project is a simple cryptocurrency wallet management system built with Java and Spring Framework. It allows users to create wallets, perform deposit and withdrawal transactions, and retrieve transaction histories.

## Table of Contents
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Example](#example)

## Getting Started

These instructions will help you set up the project on your local machine for development and testing purposes.

### Prerequisites

Ensure you have the following software installed on your machine:

- Java Development Kit (JDK) 8 or higher
- Maven
- Spring Framework

### Installation

Fork the repository to your local machine.
   
### Project Structure
src/main/java
│
├── se.inyat
│   ├── App.java                            # Main application entry point
│   ├── config
│   │   └── AppConfig.java                  # Spring configuration class
│   ├── dao
│   │   ├── TransactionDao.java             # DAO interface for transactions
│   │   └── WalletDao.java                  # DAO interface for wallets
│   ├── domain
│   │   └── entity
│   │       ├── Cryptocurrency.java         # Cryptocurrency entity
│   │       ├── Transaction.java            # Transaction entity
│   │       └── Wallet.java                 # Wallet entity
│   ├── exception
│   │   ├── WalletNotFoundException.java    # Exception for wallet not found
│   │   └── WalletValidationException.java  # Exception for wallet validation errors
│   ├── service
│   │   ├── TransactionManagement.java      # Service interface for transaction management
│   │   ├── WalletManagement.java           # Service interface for wallet management
│   │   └── impl
│   │       ├── TransactionManagementImpl.java # Implementation of TransactionManagement
│   │       └── WalletManagementImpl.java      # Implementation of WalletManagement

### Example 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.inyat.config.AppConfig;
import se.inyat.domain.entity.Cryptocurrency;
import se.inyat.domain.entity.Transaction;
import se.inyat.domain.entity.Wallet;
import se.inyat.service.TransactionManagement;
import se.inyat.service.WalletManagement;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

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

