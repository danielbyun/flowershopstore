package com.flowershop.service;

import com.flowershop.entity.Flower;
import com.flowershop.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public List<Flower> findAll() {
        List<Flower> flowerList = flowerRepository.findAll();
        List<Flower> activeFlowerList = new ArrayList<>();

        for (Flower flower : flowerList) {
            if (flower.isActive()) {
                activeFlowerList.add(flower);
            }
        }
        return activeFlowerList;
    }

    public Flower findOne(Long id) {
        return flowerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Flower> findByCategory(String category) {
        List<Flower> flowerList = flowerRepository.findByCategory(category);
        List<Flower> activeFlowerList = new ArrayList<>();

        for (Flower flower : flowerList) {
            if (flower.isActive()) {
                activeFlowerList.add(flower);
            }
        }
        return activeFlowerList;
    }

    @Override
    public List<Flower> blurrySearch(String title) {
        // findByTitleContaining is a blurrySearch function provided by Spring
        List<Flower> flowerList = flowerRepository.findByTitleContaining(title);
        List<Flower> activeFlowerList = new ArrayList<>();

        for (Flower flower : flowerList) {
            if (flower.isActive()) {
                activeFlowerList.add(flower);
            }
        }
        return activeFlowerList;
    }
}
