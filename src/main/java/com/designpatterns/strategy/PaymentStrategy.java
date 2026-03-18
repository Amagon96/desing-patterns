package com.designpatterns.strategy;

public interface PaymentStrategy {

    String execute(PaymentModel payment);
    String getType();
}
