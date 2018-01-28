package com.rigel.eventexchange.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.constraint.ConstraintLayout;
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
    TextView sellerName;
    ConstraintLayout c;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbar;
    ImageView vendorSingleImage;
    NestedScrollView sellerScroll;

    boolean startFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_page);


        startFlag = false;

        getWindow().setEnterTransition(null);

        m = getIntent().getParcelableExtra("itemSelected");

        // Binding layout to variables

        c = findViewById(R.id.sellerPageContent);
        toolbar = findViewById(R.id.tool_bar);
        collapsingToolbar = findViewById(R.id.collapsing_tool_bar);
        vendorSingleImage = findViewById(R.id.vendorSingleImage);
        sellerScroll = findViewById(R.id.sellerScroll);
        sellerName = findViewById(R.id.sellerName);


        // Set the margin of the status bar to be the same as the height of the status bar.

        ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) toolbar.getLayoutParams();
        p.setMargins(0, getStatusBarHeight(), 0, 0);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // Toolbar title is unset because otherwise it will show up before the image transition is completed.

        collapsingToolbar.setTitle("");


        vendorSingleImage.setImageResource(m.getSellerImage());

        // Helper method to handle different transition states of the item

        handleEnterAnimation();

    }


    private void handleEnterAnimation() {

        getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {

            @Override
            public void onTransitionStart(Transition transition) {

                /*
                * When returning to the old activity, the scrollview is animated to the bottom.
                * */

                if (startFlag) {
                    sellerScroll.animate().translationY(2000f).setDuration(500).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            sellerScroll.setVisibility(View.GONE);
                        }
                    });
                }

                /*
                * When going to the new activity, the scrollview is pulled from bottom.
                * */

                else {

                    sellerScroll.setTranslationY(2000f);
                    sellerScroll.animate().translationY(0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            sellerScroll.setVisibility(View.VISIBLE);
                        }
                    });

                }
            }

            /*
            * Once the shared element has finished entering the activity.
            * */

            @Override
            public void onTransitionEnd(Transition transition) {
                if (!startFlag) {
                    collapsingToolbar.setTitle(m.getSellerName());
                    startFlag = !startFlag;

                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    }
                }
            }

            /* Unused Methods */

            @Override
            public void onTransitionCancel(Transition transition) {
            }

            @Override
            public void onTransitionPause(Transition transition) {
            }

            @Override
            public void onTransitionResume(Transition transition) {
            }

        });
    }

    //To support reverse transition when user clicks the physical back button.

    @Override
    public void onBackPressed() {
        collapsingToolbar.setTitle(" ");

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        supportFinishAfterTransition();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //To support reverse transition when user clicks the action bar's Up/Home button.
            case android.R.id.home:
                collapsingToolbar.setTitle(" ");

                // Hide action bar back button.

                if (getSupportActionBar() != null)
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);

                c.setVisibility(View.GONE);
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    * Helper method to get status bar height.
    * */

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
