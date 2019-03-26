package com.flowershop.entity;

import javax.persistence.*;

@Entity
public class BillingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String billingName;
    private String billingStreet1;
    private String billingStreet2;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingZipcode;

    @OneToOne
    private Order order;

    public BillingAddress() {
    }

    public BillingAddress(String billingName, String billingStreet1, String billingStreet2, String billingCity, String billingState, String billingCountry, String billingZipcode, Order order) {
        this.billingName = billingName;
        this.billingStreet1 = billingStreet1;
        this.billingStreet2 = billingStreet2;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingCountry = billingCountry;
        this.billingZipcode = billingZipcode;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getBillingStreet1() {
        return billingStreet1;
    }

    public void setBillingStreet1(String billingStreet1) {
        this.billingStreet1 = billingStreet1;
    }

    public String getBillingStreet2() {
        return billingStreet2;
    }

    public void setBillingStreet2(String billingStreet2) {
        this.billingStreet2 = billingStreet2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingZipcode() {
        return billingZipcode;
    }

    public void setBillingZipcode(String billingZipcode) {
        this.billingZipcode = billingZipcode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "id=" + id +
                ", billingName='" + billingName + '\'' +
                ", billingStreet1='" + billingStreet1 + '\'' +
                ", billingStreet2='" + billingStreet2 + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingState='" + billingState + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", billingZipcode='" + billingZipcode + '\'' +
                ", order=" + order +
                '}';
    }
}
