package com.flowershop.service;

import com.flowershop.entity.UserPayment;
import com.flowershop.repository.UserPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {
    @Autowired
    private UserPaymentRepository userPaymentRepository;

    @Override
    public UserPayment findById(Long id) {

        return userPaymentRepository.findById(id).orElse(null);
    }

    @Override
    public void removeById(Long id) {
        userPaymentRepository.deleteById(id);
    }
}
