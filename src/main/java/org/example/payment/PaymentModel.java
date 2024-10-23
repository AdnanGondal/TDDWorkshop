package org.example.payment;

import java.util.Objects;

public class PaymentModel {

    private int amount;
    private int paymentId;
    private int wallletId;

    public PaymentModel(int amount, int wallletId, int paymentId) {
        this.amount = amount;
        this.paymentId = paymentId;
        this.wallletId = wallletId;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getWallletId() {
        return wallletId;
    }

    public void setWallletId(int wallletId) {
        this.wallletId = wallletId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentModel that = (PaymentModel) o;
        return amount == that.amount && Objects.equals(paymentId, that.paymentId) && Objects.equals(wallletId, that.wallletId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, paymentId, wallletId);
    }


}
