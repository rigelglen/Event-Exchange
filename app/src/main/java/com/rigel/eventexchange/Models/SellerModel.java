package com.rigel.eventexchange.Models;

/**
 * Created by Rigel on 27-01-2018.
 */

public class SellerModel {
    String sellerName;
    String specialization;
    int sellerImage;

    public SellerModel(String sellerName, String specialization, int sellerImage) {
        this.sellerName = sellerName;
        this.specialization = specialization;
        this.sellerImage = sellerImage;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getSellerImage() {
        return sellerImage;
    }

    public void setSellerImage(int sellerImage) {
        this.sellerImage = sellerImage;
    }
}
