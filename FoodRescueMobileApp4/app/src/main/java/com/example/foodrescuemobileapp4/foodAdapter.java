package com.example.foodrescuemobileapp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.foodViewHolder> {
    private List<com.example.foodrescuemobileapp4.Food> foodList;
    private Context context;

    public foodAdapter(List<com.example.foodrescuemobileapp4.Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.food_row, parent,false);
        return new foodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull foodAdapter.foodViewHolder holder, int position) {
        holder.foodImageView.setImageResource(foodList.get(position).getImage());
        holder.titleTextView.setText(foodList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class foodViewHolder extends RecyclerView.ViewHolder {
        public ImageView foodImageView;
        public TextView titleTextView;

        public foodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }

}
