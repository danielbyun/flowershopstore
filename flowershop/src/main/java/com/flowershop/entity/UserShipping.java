package com.flowershop.entity;

import javax.persistence.*;

@Entity
public class UserShipping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userShippingName;
    private String userShippingStreet1;
    private String userShippingStreet2;
    private String userShippingCity;
    private String userShippingState;
    private String userShippingCountry;
    private String userShippingZipcode;
    private boolean userShippingDefault;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserShipping() {
    }

    public UserShipping(String userShippingName, String userShippingStreet1, String userShippingStreet2, String userShippingCity, String userShippingState, String userShippingCountry, String userShippingZipcode, User user) {
        this.userShippingName = userShippingName;
        this.userShippingStreet1 = userShippingStreet1;
        this.userShippingStreet2 = userShippingStreet2;
        this.userShippingCity = userShippingCity;
        this.userShippingState = userShippingState;
        this.userShippingCountry = userShippingCountry;
        this.userShippingZipcode = userShippingZipcode;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserShippingName() {
        return userShippingName;
    }

    public void setUserShippingName(String userShippingName) {
        this.userShippingName = userShippingName;
    }

    public String getUserShippingStreet1() {
        return userShippingStreet1;
    }

    public void setUserShippingStreet1(String userShippingStreet1) {
        this.userShippingStreet1 = userShippingStreet1;
    }

    public String getUserShippingStreet2() {
        return userShippingStreet2;
    }

    public void setUserShippingStreet2(String userShippingStreet2) {
        this.userShippingStreet2 = userShippingStreet2;
    }

    public String getUserShippingCity() {
        return userShippingCity;
    }

    public void setUserShippingCity(String userShippingCity) {
        this.userShippingCity = userShippingCity;
    }

    public String getUserShippingState() {
        return userShippingState;
    }

    public void setUserShippingState(String userShippingState) {
        this.userShippingState = userShippingState;
    }

    public String getUserShippingCountry() {
        return userShippingCountry;
    }

    public void setUserShippingCountry(String userShippingCountry) {
        this.userShippingCountry = userShippingCountry;
    }

    public String getUserShippingZipcode() {
        return userShippingZipcode;
    }

    public void setUserShippingZipcode(String userShippingZipcode) {
        this.userShippingZipcode = userShippingZipcode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isUserShippingDefault() {
        return userShippingDefault;
    }

    public void setUserShippingDefault(boolean userShippingDefault) {
        this.userShippingDefault = userShippingDefault;
    }

    @Override
    public String toString() {
        return "UserShipping{" +
                "id=" + id +
                ", userShippingName='" + userShippingName + '\'' +
                ", userShippingStreet1='" + userShippingStreet1 + '\'' +
                ", userShippingStreet2='" + userShippingStreet2 + '\'' +
                ", userShippingCity='" + userShippingCity + '\'' +
                ", userShippingState='" + userShippingState + '\'' +
                ", userShippingCountry='" + userShippingCountry + '\'' +
                ", userShippingZipcode='" + userShippingZipcode + '\'' +
                ", user=" + user +
                '}';
    }
}