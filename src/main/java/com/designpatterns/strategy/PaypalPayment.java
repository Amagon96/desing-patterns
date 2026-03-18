package com.designpatterns.strategy;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PaypalPayment implements PaymentStrategy {

    @Override
    public String execute(PaymentModel payment) {
        return String.format(
                "%s - %s service paid for %f by %s using paypal method",
                payment.date().toString(),
                payment.service(),
                payment.amount(),
                payment.user()
        );
    }

    @Override
    public String getType() {
        return "paypal";
    }
}
