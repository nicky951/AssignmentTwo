package com.example.assignmenttwo;

import android.app.Activity;
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

//Item Adapter Class
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    //Initialise ArrayList of Items
    private ArrayList<Item> itemsToAdapt;

    //Set Data
    public void setData(ArrayList<Item> itemsToAdapt){
        this.itemsToAdapt = itemsToAdapt;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsummary, parent, false);

        ItemViewHolder ItemViewHolder = new ItemViewHolder(view);
        return ItemViewHolder;
    }

    //Logic that sets data and onclick listeners
    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        final Item itemAtPosition = itemsToAdapt.get(position);

        holder.imageImageView.setImageResource(itemAtPosition.getIntDrawableID());
        holder.nameSummaryTextView.setText(itemAtPosition.getName());
        holder.priceSummaryTextView.setText("$ " + String.valueOf(String.format("%.2f",itemAtPosition.getPrice())));

        //Intent opens a detailed view of Item when clicked
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Intent intent = new Intent(context, ItemDetail.class);
                intent.putExtra("itemNum", itemAtPosition.getItemNum());
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsToAdapt.size();
    }

    //ViewHolder that identifies views from within layouts
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageImageView;
        public TextView nameSummaryTextView;
        public TextView priceSummaryTextView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            view = itemView;

            imageImageView = itemView.findViewById(R.id.imagesummary);
            nameSummaryTextView = itemView.findViewById(R.id.itemnamesummary);
            priceSummaryTextView = itemView.findViewById(R.id.pricesummary);
        }
    }
}

