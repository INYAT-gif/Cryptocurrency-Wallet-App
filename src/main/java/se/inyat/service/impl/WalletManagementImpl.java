package se.inyat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.inyat.dao.WalletDao;
import se.inyat.exception.WalletNotFoundException;
import se.inyat.domain.entity.Wallet;
import se.inyat.exception.WalletValidationException;
import se.inyat.service.WalletManagement;

import java.util.Optional;

@Component
public class WalletManagementImpl implements WalletManagement {

    private WalletDao walletDao;

    @Autowired
    public WalletManagementImpl(WalletDao walletDao) {

        this.walletDao = walletDao;
    }

    @Override
    public Wallet create(String walletName) {
        if (walletName == null) throw new WalletValidationException("Parameter is not valid", "Wallet Name");
        //todo add more logics: if the wallet name exists or not
        Wallet wallet = new Wallet(walletName);
        return walletDao.createWallet(wallet);
    }

    @Override
    public Wallet getById(String id) {
        Optional<Wallet> optionalWallet = walletDao.findWalletById(id);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        }
        throw new WalletNotFoundException("Wallet not found.");
    }
}