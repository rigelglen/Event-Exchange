package com.rigel.eventexchange.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rigel.eventexchange.models.SellerModel;
import com.rigel.eventexchange.R;

public class SellerPage extends AppCompatActivity {

    SellerModel m;
    ImageView vendorSingleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_page);



        Toolbar toolbar= findViewById(R.id.tool_bar);

        ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
        p.setMargins(0, getStatusBarHeight(), 0, 0);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        m = getIntent().getParcelableExtra("itemSelected");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_tool_bar);
        collapsingToolbarLayout.setTitle(m.getSellerName());

        vendorSingleImage = findViewById(R.id.vendorSingleImage);
        vendorSingleImage.setImageResource(m.getSellerImage());
        vendorSingleImage.setContentDescription(m.getSellerName());



    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            supportFinishAfterTransition();
        }

        return super.onOptionsItemSelected(item);
    }

}