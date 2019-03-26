package com.flowershopAdminPortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int qty;
    private BigDecimal subTotal;

    @OneToOne
    private Flower flower;

    @OneToMany(mappedBy = "cartItem")
    @JsonIgnore
    private List<FlowerToCartItem> flowerToCartItemList;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public CartItem() {
    }

    public CartItem(int qty, BigDecimal subTotal, Flower flower, List<FlowerToCartItem> flowerToCartItemList, ShoppingCart shoppingCart, Order order) {
        this.qty = qty;
        this.subTotal = subTotal;
        this.flower = flower;
        this.flowerToCartItemList = flowerToCartItemList;
        this.shoppingCart = shoppingCart;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public List<FlowerToCartItem> getFlowerToCartItemList() {
        return flowerToCartItemList;
    }

    public void setFlowerToCartItemList(List<FlowerToCartItem> flowerToCartItemList) {
        this.flowerToCartItemList = flowerToCartItemList;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", qty=" + qty +
                ", subTotal=" + subTotal +
                ", flower=" + flower +
                ", flowerToCartItemList=" + flowerToCartItemList +
                ", shoppingCart=" + shoppingCart +
                ", order=" + order +
                '}';
    }
}
