package com.flowershop.controller;

import com.flowershop.entity.Flower;
import com.flowershop.entity.User;
import com.flowershop.service.FlowerService;
import com.flowershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    UserService userService;
    @Autowired
    FlowerService flowerService;

    @GetMapping("searchByCategory")
    public String searchByCategory(
            @RequestParam("category") String category,
            Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);

            model.addAttribute("user", user);
        }

        String classActiveCategory = "active" + category;
        classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
        classActiveCategory = classActiveCategory.replaceAll("&", "");

        model.addAttribute(classActiveCategory, true);

        List<Flower> flowerList = flowerService.findByCategory(category);

        if (flowerList.isEmpty()) {
            model.addAttribute("emptyList", true);

            return "flowerShelf";
        }

        model.addAttribute("flowerList", flowerList);

        return "flowerShelf";
    }

    @GetMapping("/searchFlower")
    public String searchFlower(
            @ModelAttribute("keyword") String keyword,
            Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);

            model.addAttribute("user", user);
        }

        List<Flower> flowerList = flowerService.blurrySearch(keyword);

        if (flowerList.isEmpty()) {
            model.addAttribute("emptyList", true);
            return "flowerShelf";
        }

        model.addAttribute("flowerList", flowerList);

        return "flowerShelf";
    }
}
