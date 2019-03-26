package com.flowershopAdminPortal.service;

import com.flowershopAdminPortal.entity.Flower;
import com.flowershopAdminPortal.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public Flower save(Flower flower) {

        return flowerRepository.save(flower);
    }

    @Override
    public List<Flower> findAll() {
        return (List<Flower>) flowerRepository.findAll();
    }

    @Override
    public Flower findById(Long id) {
        return flowerRepository.findById(id).orElse(null);
    }

    @Override
    public void removeOne(Long id) {
        flowerRepository.deleteById(id);
    }
}
