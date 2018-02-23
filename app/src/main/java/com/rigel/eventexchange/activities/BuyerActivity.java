package com.rigel.eventexchange.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rigel.eventexchange.R;
import com.rigel.eventexchange.adapters.SellerAdapter;
import com.rigel.eventexchange.models.SellerModel;

import java.util.ArrayList;

public class BuyerActivity extends AppCompatActivity {

    RecyclerView sellerRecycler;
    ArrayList<SellerModel> sellers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer);

        sellerRecycler = findViewById(R.id.sellerList);

        sellers = new ArrayList<>();

        sellers.add(new SellerModel("Seller1", "Cakes", "Good cakes", "1234567890"));
        sellers.add(new SellerModel("Seller2", "Cakes", "Good cakes", "1234567890"));
        sellers.add(new SellerModel("Seller3", "Cakes", "Good cakes", "1234567890"));


        SellerAdapter adapter = new SellerAdapter(sellers, this);

        sellerRecycler.setAdapter(adapter);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        sellerRecycler.setLayoutManager(lm);
        sellerRecycler.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(sellerRecycler.getContext(),
                LinearLayoutManager.VERTICAL);
        sellerRecycler.addItemDecoration(dividerItemDecoration);

    }




}
