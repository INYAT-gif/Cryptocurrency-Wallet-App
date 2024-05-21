package se.inyat.dao.impl;

import org.springframework.stereotype.Component;
import se.inyat.dao.WalletDao;
import se.inyat.domain.entity.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WalletDaoImpl implements WalletDao {

    private List<Wallet> storage;

    public WalletDaoImpl() {
        System.out.println("Wallet list is initialized and ready to use...");
        this.storage = new ArrayList<>();
    }

    @Override
    public Wallet createWallet(Wallet wallet) {
        storage.add(wallet);
        return wallet;
    }

    @Override
    public Optional<Wallet> findWalletById(String id) {
        Optional<Wallet> optionalWallet = storage.stream()
                .filter(wallet -> wallet.getId().equals(id))
                .findFirst();
        return optionalWallet;
    }
}