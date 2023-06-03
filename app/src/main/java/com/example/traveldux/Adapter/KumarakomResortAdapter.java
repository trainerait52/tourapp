package com.example.traveldux.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.traveldux.BookingResortActivity;
import com.example.traveldux.Models.AthriapillyResortModel;
import com.example.traveldux.Models.KumarakomResortModel;
import com.example.traveldux.R;

import java.util.List;

public class KumarakomResortAdapter extends RecyclerView.Adapter<KumarakomResortAdapter.ViewHolder> {
    Context context;
    List<KumarakomResortModel>kumarakomResortModelList;

    public KumarakomResortAdapter(Context context, List<KumarakomResortModel> kumarakomResortModelList) {
        this.context = context;
        this.kumarakomResortModelList = kumarakomResortModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.athirapillyresort,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(kumarakomResortModelList.get(position).getImg_url()).into(holder.resImg);
        holder.name.setText(kumarakomResortModelList.get(position).getName());
        holder.price.setText(kumarakomResortModelList.get(position).getPrice());
        holder.rating.setText(kumarakomResortModelList.get(position).getRating());
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, BookingResortActivity.class);
                context.startActivity(intent);
            }
        });
//        holder.discount.setText(popularPlacesModelList.get(position).getDiscount());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context, ViewHomeActivity.class);
//                intent.putExtra("type",athriapillyResortModelList.get(holder.getAdapterPosition()).getType());
//                context.startActivity(intent);
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return kumarakomResortModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView resImg;
        TextView name,price,rating;
        Button book;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            resImg=itemView.findViewById(R.id.res_img);
            name=itemView.findViewById(R.id.res_name);
            price=itemView.findViewById(R.id.res_price);
            rating=itemView.findViewById(R.id.res_rating);
            book=itemView.findViewById(R.id.booknow);
//            discount=itemView.findViewById(R.id.pop_discount);
        }
    }
}
