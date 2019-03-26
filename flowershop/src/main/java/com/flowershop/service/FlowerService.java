package com.flowershop.service;

import com.flowershop.entity.Flower;

import java.util.List;

public interface FlowerService {
    List<Flower> findAll();

    Flower findOne(Long id);

    List<Flower> findByCategory(String category);

    List<Flower> blurrySearch(String title);
}
