package com.rigel.eventexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.rigel.eventexchange.Models.SellerModel;

import java.util.ArrayList;
import java.util.List;

public class BuyerActivity extends AppCompatActivity {

    RecyclerView sellerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer);

        sellerList = findViewById(R.id.sellerList);

        ArrayList<SellerModel> sellers = new ArrayList<SellerModel>();

        sellers.add(new SellerModel("Seller1", "Cakes"));
        sellers.add(new SellerModel("Seller2", "Decoration"));
        sellers.add(new SellerModel("Seller3", "Food"));
        sellers.add(new SellerModel("Seller4", "Cakes"));
        sellers.add(new SellerModel("Seller5", "Decoration"));
        sellers.add(new SellerModel("Seller6", "Food"));






    }
}
