package org.example.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentBrokerTest {

    private PaymentBroker broker;
    private WalletInterface wallet;
    private PaymentProviderInterface provider;

    @BeforeEach
    void setUp() {
        wallet = mock(WalletInterface.class);
        provider = mock(PaymentProviderInterface.class);
        broker = new PaymentBroker(wallet, provider);
    }

    @Test
    void test_pay_returnsPaymentModel_whenWalletHasFundsAndProviderAvailable() {
        // Build
        int balance = 200;
        int amount = 100;
        int walletId = 1;
        int paymentId = 2;
        PaymentModel paymentModel = new PaymentModel(amount, walletId, paymentId);

        when(provider.isAvailable()).thenReturn(true);
        when(wallet.getBalance()).thenReturn(balance);
        when(wallet.getId()).thenReturn(walletId);
        when(provider.deposit(eq(amount), eq(walletId))).thenReturn(paymentModel);

        // Act
        var res = broker.pay(amount);

        assertThat(res.getAmount()).isEqualTo(amount);
        assertThat(res.getWallletId()).isEqualTo(walletId);
        assertThat(res.getPaymentId()).isEqualTo(paymentId);
        verify(wallet, times(1)).setBalance(eq(balance-amount));
    }

    @Test
    void test_pay_throwsInsufficientFunds_whenWalletDoesNotHaveSufficientFunds() {
        // Build
        int balance = 200;
        int amount = 250;

        when(provider.isAvailable()).thenReturn(true);
        when(wallet.getBalance()).thenReturn(balance);

        assertThrows(InsufficientFundsException.class, ()->{
            broker.pay(amount);
        });

        verify(wallet, never()).setBalance(anyInt());
        verify(wallet, never()).getId();
        verify(provider, never()).deposit(anyInt(), anyInt());
    }

    @Test
    void test_pay_throws_providerNotAvailable_whenProviderFails() {
        // Build
        int balance = 200;
        int amount = 250;

        when(wallet.getBalance()).thenReturn(balance);
        when(provider.isAvailable()).thenReturn(false);

        assertThrows(ProviderNotAvailableException.class, ()->{
            broker.pay(amount);
        });

        verify(wallet, never()).setBalance(anyInt());
        verify(wallet, never()).getId();
        verify(provider, never()).deposit(anyInt(), anyInt());
    }
}