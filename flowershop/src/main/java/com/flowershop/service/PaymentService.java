package com.flowershop.service;

import com.flowershop.entity.Payment;
import com.flowershop.entity.UserPayment;

public interface PaymentService {
    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
