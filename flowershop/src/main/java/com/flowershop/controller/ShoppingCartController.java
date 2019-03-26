package com.flowershop.controller;

import com.flowershop.entity.CartItem;
import com.flowershop.entity.Flower;
import com.flowershop.entity.ShoppingCart;
import com.flowershop.entity.User;
import com.flowershop.service.CartItemService;
import com.flowershop.service.FlowerService;
import com.flowershop.service.ShoppingCartService;
import com.flowershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/cart")
    public String shoppingCart(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart";
    }

    @RequestMapping("/addItem")
    public String addItem(
            @ModelAttribute("flower") Flower flower,
            @ModelAttribute("qty") String qty,
            Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        flower = flowerService.findOne(flower.getId());

        if (Integer.parseInt(qty) > flower.getInStockNumber()) {
            model.addAttribute("notEnoughStock", true);

            // redirect goes through the backend and therefore is slower, forward just goes to the link
            return "forward:/flowerDetail?id=" + flower.getId();
        }

        CartItem cartItem = cartItemService.addFlowerToCartItem(flower, user, Integer.parseInt(qty));
        model.addAttribute("addFlowerSuccess", true);

//        return "forward:/flowerDetail?id=" + flower.getId();
        return "redirect:/shoppingCart/cart";
    }

    @RequestMapping("/updateCartItem")
    public String updateShoppingCart(
            @ModelAttribute("id") Long cartItemId,
            @ModelAttribute("qty") int qty) {
        CartItem cartItem = cartItemService.findById(cartItemId);
        cartItem.setQty(qty);
        cartItemService.updateCartItem(cartItem);

        return "forward:/shoppingCart/cart";
    }

    @RequestMapping("/removeItem")
    public String removeItem(@RequestParam("id") Long id) {
        cartItemService.removeCartItem(cartItemService.findById(id));

        return "forward:/shoppingCart/cart";
    }
}
