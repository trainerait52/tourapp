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
import com.example.traveldux.Models.AthriapillyResortModel;
import com.example.traveldux.Models.GaviResortModel;
import com.example.traveldux.R;

import java.util.List;

public class GaviResortAdapter extends RecyclerView.Adapter<GaviResortAdapter.ViewHolder> {
    Context context;
    List<GaviResortModel>gavimodel;

    public GaviResortAdapter(Context context, List<GaviResortModel> gavimodel) {
        this.context = context;
        this.gavimodel = gavimodel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gaviresort,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(gavimodel.get(position).getImg_url()).into(holder.resImg);
        holder.name.setText(gavimodel.get(position).getName());
        holder.price.setText(gavimodel.get(position).getPrice());
        holder.rating.setText(gavimodel.get(position).getRating());
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
        return gavimodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView resImg;
        TextView name,price,rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            resImg=itemView.findViewById(R.id.res_img);
            name=itemView.findViewById(R.id.res_name);
            price=itemView.findViewById(R.id.res_price);
            rating=itemView.findViewById(R.id.res_rating);
//            discount=itemView.findViewById(R.id.pop_discount);
        }
    }
}
