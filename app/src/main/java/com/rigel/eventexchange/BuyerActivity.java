package com.rigel.eventexchange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rigel.eventexchange.Adapters.SellerAdapter;
import com.rigel.eventexchange.Models.SellerModel;

import java.util.ArrayList;

public class BuyerActivity extends AppCompatActivity {

    RecyclerView sellerRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer);

        sellerRecycler = findViewById(R.id.sellerList);

        ArrayList<SellerModel> sellers = new ArrayList<>();

        sellers.add(new SellerModel("Seller1", "Cakes", R.drawable.ic_launcher_foreground));
        sellers.add(new SellerModel("Seller2", "Decoration", R.drawable.ic_launcher_foreground));
        sellers.add(new SellerModel("Seller3", "Food", R.drawable.ic_launcher_foreground));
        sellers.add(new SellerModel("Seller4", "Cakes", R.drawable.ic_launcher_foreground));
        sellers.add(new SellerModel("Seller5", "Decoration", R.drawable.ic_launcher_foreground));
        sellers.add(new SellerModel("Seller6", "Food", R.drawable.ic_launcher_foreground));

        SellerAdapter adapter = new SellerAdapter(sellers);

        sellerRecycler.setAdapter(adapter);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        sellerRecycler.setLayoutManager(lm);
        sellerRecycler.setItemAnimator(new DefaultItemAnimator());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(sellerRecycler.getContext(),
                LinearLayoutManager.VERTICAL);
        sellerRecycler.addItemDecoration(dividerItemDecoration);







    }
}
