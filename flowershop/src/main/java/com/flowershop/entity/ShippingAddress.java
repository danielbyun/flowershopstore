package com.flowershop.entity;

import javax.persistence.*;

@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shippingName;
    private String shippingStreet1;
    private String shippingStreet2;
    private String shippingCity;
    private String shippingState;
    private String shippingCountry;
    private String shippingZipcode;

    @OneToOne
    private Order order;

    public ShippingAddress() {
    }

    public ShippingAddress(String shippingName, String shippingStreet1, String shippingStreet2, String shippingCity, String shippingState, String shippingCountry, String shippingZipcode, Order order) {
        this.shippingName = shippingName;
        this.shippingStreet1 = shippingStreet1;
        this.shippingStreet2 = shippingStreet2;
        this.shippingCity = shippingCity;
        this.shippingState = shippingState;
        this.shippingCountry = shippingCountry;
        this.shippingZipcode = shippingZipcode;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShippingStreet1() {
        return shippingStreet1;
    }

    public void setShippingStreet1(String shippingStreet1) {
        this.shippingStreet1 = shippingStreet1;
    }

    public String getShippingStreet2() {
        return shippingStreet2;
    }

    public void setShippingStreet2(String shippingStreet2) {
        this.shippingStreet2 = shippingStreet2;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getShippingState() {
        return shippingState;
    }

    public void setShippingState(String shippingState) {
        this.shippingState = shippingState;
    }

    public String getShippingCountry() {
        return shippingCountry;
    }

    public void setShippingCountry(String shippingCountry) {
        this.shippingCountry = shippingCountry;
    }

    public String getShippingZipcode() {
        return shippingZipcode;
    }

    public void setShippingZipcode(String shippingZipcode) {
        this.shippingZipcode = shippingZipcode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "shipping{" +
                "id=" + id +
                ", shippingName='" + shippingName + '\'' +
                ", shippingStreet1='" + shippingStreet1 + '\'' +
                ", shippingStreet2='" + shippingStreet2 + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                ", shippingState='" + shippingState + '\'' +
                ", shippingCountry='" + shippingCountry + '\'' +
                ", shippingZipcode='" + shippingZipcode + '\'' +
                ", order=" + order +
                '}';
    }
}
