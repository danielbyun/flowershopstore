package com.flowershopAdminPortal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String size;
    private String category;
    private int itemNumber;
    private double shippingWeight;
    private double listPrice;
    private double ourPrice;
    private boolean active = true;

    @Column(columnDefinition = "text")
    private String description;
    private int inStockNumber;

    // won't be stored in the database
    @Transient
    private MultipartFile flowerImage;

    @OneToMany(mappedBy = "flower")
    @JsonIgnore
    private List<FlowerToCartItem> flowerToCartItemList;

    public Flower() {
    }

    public Flower(String title, String size, String category, int itemNumber, double shippingWeight, double listPrice, double ourPrice, boolean active, String description, int inStockNumber, MultipartFile flowerImage) {
        this.title = title;
        this.size = size;
        this.category = category;
        this.itemNumber = itemNumber;
        this.shippingWeight = shippingWeight;
        this.listPrice = listPrice;
        this.ourPrice = ourPrice;
        this.active = active;
        this.description = description;
        this.inStockNumber = inStockNumber;
        this.flowerImage = flowerImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(double ourPrice) {
        this.ourPrice = ourPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInStockNumber() {
        return inStockNumber;
    }

    public void setInStockNumber(int inStockNumber) {
        this.inStockNumber = inStockNumber;
    }

    public MultipartFile getFlowerImage() {
        return flowerImage;
    }

    public void setFlowerImage(MultipartFile flowerImage) {
        this.flowerImage = flowerImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<FlowerToCartItem> getFlowerToCartItemList() {
        return flowerToCartItemList;
    }

    public void setFlowerToCartItemList(List<FlowerToCartItem> flowerToCartItemList) {
        this.flowerToCartItemList = flowerToCartItemList;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", size='" + size + '\'' +
                ", category='" + category + '\'' +
                ", itemNumber=" + itemNumber +
                ", shippingWeight=" + shippingWeight +
                ", listPrice=" + listPrice +
                ", ourPrice=" + ourPrice +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", inStockNumber=" + inStockNumber +
                ", flowerImage=" + flowerImage +
                ", flowerToCartItemList=" + flowerToCartItemList +
                '}';
    }
}
