package com.flowershopAdminPortal.controller;

import com.flowershopAdminPortal.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ResourceController {
    @Autowired
    private FlowerService flowerService;

    @PostMapping("/flower/removeList")
    public String removeList(@RequestBody ArrayList<String> flowerIdList,
                             Model model) {
        for (String id : flowerIdList) {
            String flowerId = id.substring(8);
            flowerService.removeOne(Long.parseLong(flowerId));
        }
        return "delete success";
    }
}
