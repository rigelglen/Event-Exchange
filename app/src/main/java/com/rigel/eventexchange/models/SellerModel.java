package com.rigel.eventexchange.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Rigel on 27-01-2018.
 *
 * For Seller List
 *
 */

public class SellerModel implements Parcelable{
    private String sellerName;
    private String specialization;
    private int sellerImage;
    private int sellerId;

    public SellerModel(String sellerName, String specialization, int sellerImage, int sellerId) {
        this.sellerName = sellerName;
        this.specialization = specialization;
        this.sellerImage = sellerImage;
        this.sellerId = sellerId;
    }

    private SellerModel(Parcel in) {
        sellerName = in.readString();
        specialization = in.readString();
        sellerImage = in.readInt();
        sellerId = in.readInt();
    }

    public static final Creator<SellerModel> CREATOR = new Creator<SellerModel>() {
        @Override
        public SellerModel createFromParcel(Parcel in) {
            return new SellerModel(in);
        }

        @Override
        public SellerModel[] newArray(int size) {
            return new SellerModel[size];
        }
    };

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

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sellerName);
        dest.writeString(specialization);
        dest.writeInt(sellerImage);
        dest.writeInt(sellerId);
    }
}
