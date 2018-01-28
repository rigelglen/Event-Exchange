package com.rigel.eventexchange.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rigel.eventexchange.adapters.SellerAdapter;
import com.rigel.eventexchange.models.SellerModel;
import com.rigel.eventexchange.R;

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

        sellers.add(new SellerModel("Seller1", "Cakes", R.drawable.image, 1));
        sellers.add(new SellerModel("Seller2", "Decoration", R.drawable.image, 2));
        sellers.add(new SellerModel("Seller3", "Food", R.drawable.image, 3));
        sellers.add(new SellerModel("Seller4", "Cakes", R.drawable.image, 4));
        sellers.add(new SellerModel("Seller5", "Decoration", R.drawable.image, 5));
        sellers.add(new SellerModel("Seller6", "Food", R.drawable.image, 6));
        sellers.add(new SellerModel("Seller7", "Food", R.drawable.image, 7));
        sellers.add(new SellerModel("Seller8", "Food", R.drawable.image, 8));
        sellers.add(new SellerModel("Seller9", "Food", R.drawable.image, 9));
        sellers.add(new SellerModel("Seller10", "Food", R.drawable.image, 10));
        sellers.add(new SellerModel("Seller11", "Food", R.drawable.image, 11));
        sellers.add(new SellerModel("Seller12", "Food", R.drawable.image, 12));
        sellers.add(new SellerModel("Seller13", "Food", R.drawable.image, 13));
        sellers.add(new SellerModel("Seller14", "Food", R.drawable.image, 14));
        sellers.add(new SellerModel("Seller15", "Food", R.drawable.image, 15));

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
