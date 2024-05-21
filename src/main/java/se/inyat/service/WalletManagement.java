package se.inyat.service;

import se.inyat.domain.entity.Wallet;

public interface WalletManagement {
    Wallet create(String walletName);

    Wallet getById(String id);

    // ...
}