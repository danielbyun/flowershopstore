package com.flowershop.service;

import com.flowershop.entity.BillingAddress;
import com.flowershop.entity.UserBilling;
import org.springframework.stereotype.Service;

@Service
public class BillingAddressServiceImpl implements BillingAddressService {
    @Override
    public BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress) {
        billingAddress.setBillingName(userBilling.getUserBillingName());
        billingAddress.setBillingStreet1(userBilling.getUserBillingStreet1());
        billingAddress.setBillingStreet2(userBilling.getUserBillingStreet2());
        billingAddress.setBillingCity(userBilling.getUserBillingCity());
        billingAddress.setBillingState(userBilling.getUserBillingState());
        billingAddress.setBillingCountry(userBilling.getUserBillingCountry());
        billingAddress.setBillingZipcode(userBilling.getUserBillingZipcode());

        return billingAddress;
    }
}
