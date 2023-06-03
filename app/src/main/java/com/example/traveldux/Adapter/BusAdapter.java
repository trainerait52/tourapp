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
import com.example.traveldux.Models.BusModel;
import com.example.traveldux.Models.RailModel;
import com.example.traveldux.R;

import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {
    Context context;
    List<BusModel> busModelList;

    public BusAdapter(Context context, List<BusModel> busModelList) {
        this.context = context;
        this.busModelList = busModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bus_stations,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(busModelList.get(position).getImg_url()).into(holder.imageView);
        holder.name.setText(busModelList.get(position).getName());
//        holder.rating.setText(busModelList.get(position).getRating());
//        holder.address.setText(busModelList.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return busModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, rating, address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.bus_img);
            name = itemView.findViewById(R.id.bus_name);
//            rating=itemView.findViewById(R.id.bus_rating);
//            address=itemView.findViewById(R.id.bus_address);

        }
    }

}
