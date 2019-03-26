package com.flowershop.service;

import com.flowershop.entity.*;

public interface OrderService {
    Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress, Payment payment, String shippingMethod, User user);

    Order findById(Long id);
}
