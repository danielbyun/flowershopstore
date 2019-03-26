package com.flowershopAdminPortal.controller;

import com.flowershopAdminPortal.entity.Flower;
import com.flowershopAdminPortal.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/flower")
public class FlowerController {
    // system directory
//    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/img/flower/";

    private Logger logger = Logger.getLogger(getClass().getName());
    @Autowired
    private FlowerService flowerService;

    // /Users/DanielByun/Documents/java/udemy/spring_hibernate/flowershop-admin-portal/src/main/resources/static/img/flower
    @RequestMapping("/add")
    public String addFlower(Model model) {
        Flower flower = new Flower();
        model.addAttribute("flower", flower);

        return "addFlower";
    }


    @PostMapping("/add")
    public String addFlowerPost(
            @ModelAttribute("flower") Flower flower,
            HttpServletRequest request) {
        // you need to save and persist the data first so we can get the generated ID to use later
        flowerService.save(flower);

        // product image
        MultipartFile flowerImage = flower.getFlowerImage();

        try {
            byte[] bytes = flowerImage.getBytes();

            // assign name
            String name = flower.getId() + ".jpeg";

            // filepath = "src/main/resources/static/img/flower/"
            String filePath = request.getSession().getServletContext().getRealPath("/") + "src/main/resources/static/img/flower/";

//            flowerImage.transferTo(new File(filePath + name));
            // generate new file into the static / resources folder
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + name)));
//            /* tip: server has to restart to see the changes */
//            // probably better to store into AWS and host it there
            stream.write(bytes);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:flowerList";
    }

    @RequestMapping("/updateFlower")
    public String updateFlower(@RequestParam("id") Long id,
                               Model model) {
        Flower flower = flowerService.findById(id);
        model.addAttribute("flower", flower);

        return "flowerUpdate";
    }

    @PostMapping("/updateFlower")
    public String updateFlowerPost(@ModelAttribute("flower") Flower flower,
                                   HttpServletRequest request) {
        flowerService.save(flower);

        MultipartFile flowerImage = flower.getFlowerImage();

        if (!flowerImage.isEmpty()) {
            try {
                byte[] bytes = flowerImage.getBytes();

                // assign name
                String name = flower.getId() + ".jpeg";
                Files.delete(Paths.get("src/main/resources/static/img/flower/" + name));

                logger.info("name: " + name);

                // generate new file into the static / resources folder
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/img/flower/" + name)));
                /* tip: server has to restart to see the changes */
                // probably better to store into AWS and host it there || even just put it in the database
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/flower/flowerInfo?id=" + flower.getId();
    }

    // list of all products
    @RequestMapping("/flowerList")
    public String flowerList(Model model) {
        List<Flower> flowerList = flowerService.findAll();
        model.addAttribute("flowerList", flowerList);

        return "flowerList";
    }

    // get a page with one just product
    @RequestMapping("/flowerInfo")
    public String flowerInfo(@RequestParam("id") Long id,
                             Model model) {
        Flower flower = flowerService.findById(id);
        model.addAttribute("flower", flower);

        return "flowerInfo";
    }

    @PostMapping("/remove")
    public String remove(@ModelAttribute("id") String id,
                         Model model) {
        // take the first 10 characters out, from 'oneflower-{id}'
        logger.info(id);
        logger.info("id: " + Long.parseLong(id.substring(10)));
        flowerService.removeOne(Long.parseLong(id.substring(10)));
        List<Flower> flowerList = flowerService.findAll();
        model.addAttribute("flowerList", flowerList);

        return "redirect:/flower/flowerList";

    }
}
