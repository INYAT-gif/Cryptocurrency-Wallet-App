package se.inyat.service.impl;

import se.inyat.dao.WalletDao;
import se.inyat.exception.WalletNotFoundException;
import se.inyat.model.Wallet;
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
        if (walletName == null) throw new IllegalArgumentException("Param is not valid.", "Wallet Name");
            Wallet wallet = new Wallet(walletName);
            return walletDao.createWallet(wallet);
    }

    @Override
    public Wallet getById(String id) {
        Optional<Wallet> optionalWallet = walletDao.findWallet(id);
        if (optionalWallet.isEmpty()) throw new WalletNotFoundException("Wallet not found.");
        return optionalWallet.get();
    }

}