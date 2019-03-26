package com.flowershop.service;

import com.flowershop.entity.*;
import com.flowershop.repository.CartItemRepository;
import com.flowershop.repository.FlowerToCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private FlowerToCartItemRepository flowerToCartItemRepository;

    @Override
    public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal bigDecimal = new BigDecimal(cartItem.getFlower().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));

        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        cartItem.setSubTotal(bigDecimal);

        cartItemRepository.save(cartItem);

        return cartItem;
    }

    @Override
    public CartItem addFlowerToCartItem(Flower flower, User user, int qty) {
        List<CartItem> cartItemList = cartItemService.findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if (flower.getId().equals(cartItem.getFlower().getId())) {
                cartItem.setQty(cartItem.getQty() + qty);
                cartItem.setSubTotal(new BigDecimal(flower.getOurPrice()).multiply(new BigDecimal(qty)));
                cartItemRepository.save(cartItem);

                return cartItem;
            }
        }
        // if the item is new
        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setFlower(flower);

        cartItem.setQty(qty);
        cartItem.setSubTotal(new BigDecimal(flower.getOurPrice()).multiply(new BigDecimal(qty)));
        cartItem = cartItemRepository.save(cartItem);

        FlowerToCartItem flowerToCartItem = new FlowerToCartItem();
        flowerToCartItem.setFlower(flower);
        flowerToCartItem.setCartItem(cartItem);
        flowerToCartItemRepository.save(flowerToCartItem);

        return cartItem;
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        flowerToCartItemRepository.deleteByCartItem(cartItem);
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findByOrder(Order order) {

        return cartItemRepository.findByOrder(order);
    }
}
