package com.example.assignmenttwo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TotalAdapter extends RecyclerView.Adapter<TotalAdapter.TotalViewHolder> {

    private ArrayList<ItemTotal> itemsToAdapt;

    public void setData(ArrayList<ItemTotal> itemsToAdapt) {
        this.itemsToAdapt = itemsToAdapt;
    }

    @NonNull
    @Override
    public TotalAdapter.TotalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ordersummary, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        TotalViewHolder TotalViewHolder = new TotalAdapter.TotalViewHolder(view);

        return TotalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TotalAdapter.TotalViewHolder holder, int position) {
        final ItemTotal itemAtPosition = itemsToAdapt.get(position);

        holder.imageImageView.setImageResource(itemAtPosition.getItem().getIntDrawableID());
        holder.quantityTextView.setText(Integer.toString(itemAtPosition.getTotalQuantity()));
        holder.priceTextView.setText(String.format("%.2f", itemAtPosition.getTotalPrice()));
        holder.nameTextView.setText(itemAtPosition.getItem().getName());
    }

    @Override
    public int getItemCount() {
        return itemsToAdapt.size();
    }

    public static class TotalViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageImageView;
        public TextView quantityTextView;
        public TextView nameTextView;
        public TextView priceTextView;

        public TotalViewHolder(@NonNull View totalView) {
            super(totalView);

            view = totalView;

            imageImageView = totalView.findViewById(R.id.imagedetail);
            quantityTextView = totalView.findViewById(R.id.quantitydetail);
            nameTextView = totalView.findViewById(R.id.namedetail);
            priceTextView = totalView.findViewById(R.id.totaldetail);

        }
    }
}
