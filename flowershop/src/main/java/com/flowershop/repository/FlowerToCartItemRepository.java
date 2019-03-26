package com.flowershop.repository;

import com.flowershop.entity.CartItem;
import com.flowershop.entity.FlowerToCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FlowerToCartItemRepository extends JpaRepository<FlowerToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
