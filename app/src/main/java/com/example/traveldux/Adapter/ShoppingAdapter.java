package com.example.traveldux.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.traveldux.Models.ShoppingModel;
import com.example.traveldux.R;

import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {
    Context context;
    List<ShoppingModel>shoppingModelList;

    public ShoppingAdapter(Context context, List<ShoppingModel> shoppingModelList) {
        this.context = context;
        this.shoppingModelList = shoppingModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_page,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(shoppingModelList.get(position).getImg_url()).into(holder.imageView);
        holder.name.setText(shoppingModelList.get(position).getName());
//        holder.rating.setText(shoppingModelList.get(position).getRating());
//        holder.address.setText(shoppingModelList.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return shoppingModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.shop_img);
            name=itemView.findViewById(R.id.shop_name);
//            rating=itemView.findViewById(R.id.shop_rating);
//            address=itemView.findViewById(R.id.shop_address);



        }
    }
}
