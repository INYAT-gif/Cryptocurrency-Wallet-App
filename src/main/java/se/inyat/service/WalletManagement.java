package se.inyat.service;

import se.inyat.model.Wallet;

public interface WalletManagement {
    Wallet create(String walletName);
    Wallet getById(String id);
    //Wallet getByName(String name);
    //Wallet getByAddress(String address);
    //List<Wallet> getAll();
    //void delete(String id);
    //void update(Wallet wallet);
    //void update(String id, Wallet wallet);
    //void update(String id, String name);
    //void update(String id, String name, String address);
    //void update(String id, String name, String address, BigDecimal balance);
    //void update(String id, String name, String address, BigDecimal balance, String currency);

}
