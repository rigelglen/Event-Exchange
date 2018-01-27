package com.rigel.eventexchange.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rigel.eventexchange.Models.SellerModel;
import com.rigel.eventexchange.R;

import java.util.ArrayList;

/**
 * Created by Rigel on 27-01-2018.
 *
 * For Seller List
 *
 */

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.ViewHolder>{
    private ArrayList<SellerModel> sellerList;
    public SellerAdapter(ArrayList<SellerModel> sellerList){
        this.sellerList = sellerList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_buyer_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SellerModel model = sellerList.get(position);

        holder.vendorName.setText(model.getSellerName());
        holder.vendorDescription.setText(model.getSpecialization());
        holder.vendorImage.setImageResource(model.getSellerImage());
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

        }
    }
}
