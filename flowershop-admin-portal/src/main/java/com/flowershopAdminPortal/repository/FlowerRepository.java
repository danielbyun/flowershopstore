package com.flowershopAdminPortal.repository;

import com.flowershopAdminPortal.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

}
