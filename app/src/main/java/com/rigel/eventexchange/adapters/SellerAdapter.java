package com.rigel.eventexchange.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rigel.eventexchange.models.SellerModel;
import com.rigel.eventexchange.activities.SellerPage;
import com.rigel.eventexchange.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rigel on 27-01-2018.
 *
 * For Seller List
 *
 */

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.ViewHolder>{

    private ArrayList<SellerModel> sellerList;
    private Context ctx;

    public SellerAdapter(ArrayList<SellerModel> sellerList, Context ctx){
        this.sellerList = sellerList;
        this.ctx = ctx;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_buyer, parent, false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SellerModel model = sellerList.get(position);
        holder.vendorName.setText(model.getSellerName());
        holder.vendorDescription.setText(model.getSellerType());
        if(!model.getPic().isEmpty())
            Picasso.with(ctx).load(model.getPic()).into(holder.vendorImage);
        else
            holder.vendorImage.setImageResource(R.drawable.image);

    }

    @Override
    public int getItemCount() {
        return sellerList.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{

        TextView vendorName;
        TextView vendorDescription;
        ImageView vendorImage;


         ViewHolder(View itemView) {
            super(itemView);

            vendorName = itemView.findViewById(R.id.vendorName);
            vendorDescription = itemView.findViewById(R.id.vendorDescription);
            vendorImage = itemView.findViewById(R.id.vendorImage);


             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(final View v) {

                     v.setClickable(false);

                     Intent it = new Intent(ctx, SellerPage.class);

                     it.putExtra("itemSelected", sellerList.get(getAdapterPosition()));

                     View sharedImage = v.findViewById(R.id.vendorImage);

                     ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)ctx, sharedImage, ViewCompat.getTransitionName(sharedImage));

                     ctx.startActivity(it, options.toBundle());

                     // Prevent multiple clicks on the item

                     new Handler().postDelayed(new Runnable() {

                         @Override
                         public void run() {
                             v.setClickable(true);
                         }
                     }, 1000);

                 }
             });


        }
    }

}
