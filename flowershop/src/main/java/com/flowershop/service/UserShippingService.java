package com.flowershop.service;

import com.flowershop.entity.UserShipping;

public interface UserShippingService {
    UserShipping findById(Long id);

    void removeById(Long id);
}
