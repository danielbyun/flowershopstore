package com.flowershop.service;

import com.flowershop.entity.UserPayment;

public interface UserPaymentService {
    UserPayment findById(Long id);
    void removeById(Long id);
}
