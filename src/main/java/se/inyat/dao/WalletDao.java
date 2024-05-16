package se.inyat.dao;

import se.inyat.model.Wallet;

import java.util.Optional;

public interface WalletDao {
    Wallet createWallet(Wallet wallet);
    Optional<Wallet> findWallet(String id);

    // TODO: Add more methods

    }

