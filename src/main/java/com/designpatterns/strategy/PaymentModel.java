package com.designpatterns.strategy;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentModel(
        String user,
        String service,
        BigDecimal amount,
        LocalDate date
) {}
