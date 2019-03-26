package com.flowershop.service;

import com.flowershop.entity.BillingAddress;
import com.flowershop.entity.UserBilling;

public interface BillingAddressService {
    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
