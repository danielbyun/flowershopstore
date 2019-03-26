package com.flowershop.repository;

import com.flowershop.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
    List<Flower> findByCategory(String category);
    List<Flower> findByTitleContaining(String keyword);
}
