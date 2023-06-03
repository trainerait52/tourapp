package com.example.traveldux.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.traveldux.Models.PopularPlacesModel;
import com.example.traveldux.R;
import com.example.traveldux.ViewHomeActivity;

import java.util.List;

public class PopularPlacesAdapter extends RecyclerView.Adapter<PopularPlacesAdapter.ViewHolder> {
    Context context;
    List<PopularPlacesModel>popularPlacesModelList;

    public PopularPlacesAdapter(Context context, List<PopularPlacesModel> popularPlacesModelList) {
        this.context = context;
        this.popularPlacesModelList = popularPlacesModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_places,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(popularPlacesModelList.get(position).getImg_url()).into(holder.popImg);
        holder.name.setText(popularPlacesModelList.get(position).getName());
        holder.price.setText(popularPlacesModelList.get(position).getPrice());
        holder.rating.setText(popularPlacesModelList.get(position).getRating());
//        holder.discount.setText(popularPlacesModelList.get(position).getDiscount());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ViewHomeActivity.class);
                intent.putExtra("type",popularPlacesModelList.get(holder.getAdapterPosition()).getType());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return popularPlacesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView popImg;
        TextView name,price,rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            popImg=itemView.findViewById(R.id.pop_img);
            name=itemView.findViewById(R.id.pop_name);
            price=itemView.findViewById(R.id.pop_price);
            rating=itemView.findViewById(R.id.pop_rating);
//            discount=itemView.findViewById(R.id.pop_discount);
        }
    }
}
