package se.inyat.dao;

import se.inyat.domain.entity.Wallet;

import java.util.Optional;

public interface WalletDao {
    Wallet createWallet(Wallet wallet);
    Optional<Wallet> findWalletById(String id);

    // TODO: Add more methods

    }

