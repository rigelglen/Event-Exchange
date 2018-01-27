package com.rigel.eventexchange.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rigel.eventexchange.Models.SellerModel;
import com.rigel.eventexchange.R;

import java.util.ArrayList;

/**
 * Created by Rigel on 27-01-2018.
 */

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.ViewHolder>{
    ArrayList<SellerModel> sellerList;
    public SellerAdapter(ArrayList<SellerModel> sellerList){
        this.sellerList = sellerList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return sellerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView sellerName;
        TextView specialization;
        ImageView sellerImage;

        public ViewHolder(View itemView) {
            super(itemView);

            sellerName = itemView.findViewById(R.id.)

        }
    }
}
