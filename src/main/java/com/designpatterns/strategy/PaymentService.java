package com.designpatterns.strategy;

import org.springframework.stereotype.Service;

import java.util.Map;

// Context
@Service
public class PaymentService {

    // Spring injects automatically all beans implementing PaymentStrategy.
    private final Map<String, PaymentStrategy> strategyMap;

    public PaymentService(Map<String, PaymentStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    String processPayment(PaymentModel payment, String paymentType) {
        PaymentStrategy strategy = strategyMap.get(paymentType);
        if (strategy == null) throw new IllegalArgumentException("404 - Strategy not found");
        return strategy.execute(payment);
    }
}
