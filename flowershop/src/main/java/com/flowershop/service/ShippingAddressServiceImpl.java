package com.flowershop.service;

import com.flowershop.entity.ShippingAddress;
import com.flowershop.entity.UserShipping;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
    @Override
    public ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress) {
        shippingAddress.setShippingName(userShipping.getUserShippingName());
        shippingAddress.setShippingStreet1(userShipping.getUserShippingStreet1());
        shippingAddress.setShippingStreet2(userShipping.getUserShippingStreet2());
        shippingAddress.setShippingCity(userShipping.getUserShippingCity());
        shippingAddress.setShippingState(userShipping.getUserShippingState());
        shippingAddress.setShippingCountry(userShipping.getUserShippingCountry());
        shippingAddress.setShippingZipcode(userShipping.getUserShippingZipcode());

        return shippingAddress;
    }
}
