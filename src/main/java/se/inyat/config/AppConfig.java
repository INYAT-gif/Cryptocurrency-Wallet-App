package se.inyat.config;

import se.inyat.dao.impl.TransactionDaoImpl;
import se.inyat.dao.impl.WalletDaoImpl;
import se.inyat.service.WalletManagement;
import se.inyat.service.impl.TransactionManagementImpl;
import se.inyat.service.impl.WalletManagementImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "se.inyat")
public class AppConfig {

    /**@Bean
    public TransactionDaoImpl transactionDao(){
        return new TransactionDaoImpl();
    }

    @Bean
    public WalletDaoImpl walletDao(){
        return new WalletDaoImpl();
    }

    @Bean
    public TransactionManagementImpl transactionManagement(){
        return new TransactionManagementImpl(walletDao(), transactionDao());
    }

    @Bean
    public WalletManagementImpl walletManagement(){
        return new WalletManagementImpl(walletDao());
    }

*/
}