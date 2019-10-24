package com.example.assignmenttwo;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Adapter for the orders page
public class TotalAdapter extends RecyclerView.Adapter<TotalAdapter.TotalViewHolder> {

    private ArrayList<ItemTotal> itemsToAdapt;

    public void setData(ArrayList<ItemTotal> itemsToAdapt) {
        this.itemsToAdapt = itemsToAdapt;
    }

    @NonNull
    @Override
    public TotalAdapter.TotalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ordersummary, parent, false);

        TotalViewHolder TotalViewHolder = new TotalAdapter.TotalViewHolder(view);

        return TotalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TotalAdapter.TotalViewHolder holder, final int position) {
        final ItemTotal itemAtPosition = itemsToAdapt.get(position);

        //Set data for each item on recycler view
        holder.imageImageView.setImageResource(itemAtPosition.getItem().getIntDrawableID());
        holder.quantityTextView.setText(Integer.toString(itemAtPosition.getTotalQuantity()));
        holder.priceTextView.setText(String.format("%.2f", itemAtPosition.getTotalPrice()));
        holder.nameTextView.setText(itemAtPosition.getItem().getName());

        //Delete item logic
        holder.delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                itemsToAdapt.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, itemsToAdapt.size());

                Toast toast = Toast.makeText(v.getContext(), "Item Removed" , Toast.LENGTH_SHORT );
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                Context context = v.getContext();

                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsToAdapt.size();
    }

    //Identify and bind Ids to elements
    public static class TotalViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageImageView;
        public TextView quantityTextView;
        public TextView nameTextView;
        public TextView priceTextView;
        public Button delete;

        public TotalViewHolder(@NonNull View totalView) {
            super(totalView);

            view = totalView;

            imageImageView = totalView.findViewById(R.id.imagedetail);
            quantityTextView = totalView.findViewById(R.id.quantitydetail);
            nameTextView = totalView.findViewById(R.id.namedetail);
            priceTextView = totalView.findViewById(R.id.totaldetail);
            delete = totalView.findViewById(R.id.remove);

        }
    }
}
