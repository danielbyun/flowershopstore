package com.flowershop.service;

import com.flowershop.entity.ShippingAddress;
import com.flowershop.entity.UserShipping;

public interface ShippingAddressService {
    ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
