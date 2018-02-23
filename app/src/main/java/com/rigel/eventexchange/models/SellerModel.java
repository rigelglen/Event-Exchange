package com.rigel.eventexchange.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hp on 28-01-2018.
 */

public class SellerModel implements Parcelable{
    private String name;
    private String sellerType;
    private String description;
    private String number;
    private String pic;
    private String Type;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    protected SellerModel(Parcel in) {
        name = in.readString();
        sellerType = in.readString();
        description = in.readString();
        number = in.readString();
        pic = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(sellerType);
        dest.writeString(description);
        dest.writeString(number);
        dest.writeString(pic);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    //    public String getType(){
//        return "Seller";
//    }

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)

    public SellerModel(){

    }

    public SellerModel(String name, String type, String description, String number) {
        this.name = name;
        this.sellerType = type;
        this.description = description;
        this.number = number;
        this.pic = "";
    }

    public SellerModel(String name, String type, String description, String number, String pic) {
        this.name = name;
        this.sellerType = type;
        this.description = description;
        this.number = number;
        this.pic = pic;
    }

    public String getSellerName() {

        return name;
    }

    public void setSellerName(String name) {

        this.name = name;
    }


    public String getSellerType() {

        return sellerType;
    }

    public void setSellerType(String type) {

        this.sellerType = type;
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

