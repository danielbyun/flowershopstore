package com.flowershopAdminPortal.entity;

import javax.persistence.*;

@Entity
public class FlowerToCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flower_id")
    private Flower flower;

    @ManyToOne
    @JoinColumn(name = "cart_item_id")
    private CartItem cartItem;

    public FlowerToCartItem() {
    }

    public FlowerToCartItem(Flower flower, CartItem cartItem) {
        this.flower = flower;
        this.cartItem = cartItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "FlowerToCartItem{" +
                "id=" + id +
                ", flower=" + flower +
                ", cartItem=" + cartItem +
                '}';
    }
}
