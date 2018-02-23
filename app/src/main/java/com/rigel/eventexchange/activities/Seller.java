package com.rigel.eventexchange.activities;

/**
 * Created by hp on 28-01-2018.
 */

public class Seller {
    private String name;
    private String type;
    private String description;
    private String number;
    private String userType="Seller";

    public String getType(){
        return  userType;
    }

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Seller() {
    }


    public String getSellerName() {

        return name;
    }

    public void setSellerName(String name) {

        this.name = name;
    }


    public String getSellerType() {

        return type;
    }

    public void setSellerType(String type) {

        this.type = type;
    }

    public String getSellerDescription() {

        return description;
    }

    public void setSellerDescription(String description) {

        this.description = description;
    }
    public String getSellerNumber() {

        return number;
    }

    public void setSellerNumber(String number) {

        this.number = number;
    }
}

