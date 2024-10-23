package org.example.payment;

public interface PaymentProviderInterface {
    boolean isAvailable();
    PaymentModel deposit(int id, int amount);

}
