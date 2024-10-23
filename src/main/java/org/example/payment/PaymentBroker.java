package org.example.payment;

import org.example.login.InvalidCredentialsException;

public class PaymentBroker {

    private final WalletInterface wallet;
    private final PaymentProviderInterface provider;


    public PaymentBroker(WalletInterface wallet, PaymentProviderInterface provider) {
        this.wallet = wallet;
        this.provider = provider;
    }

    public PaymentModel pay(int amount){

        if (!provider.isAvailable()){
            throw  new ProviderNotAvailableException();
        }

        if (amount > wallet.getBalance()){
            throw new InsufficientFundsException();
        }

        wallet.setBalance(wallet.getBalance()-amount);

        return provider.deposit(amount, wallet.getId());
    }
}
