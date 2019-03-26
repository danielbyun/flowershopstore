package com.flowershopAdminPortal.service;

import com.flowershopAdminPortal.entity.Flower;

import java.util.List;

public interface FlowerService {
    Flower save(Flower flower);
    List<Flower> findAll();
    Flower findById(Long id);
    void removeOne(Long id);
}
