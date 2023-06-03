package com.example.traveldux.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.traveldux.AthirapillyResortsActivity;
import com.example.traveldux.BookingPlaceActivity;
import com.example.traveldux.Models.ViewHomeModel;
import com.example.traveldux.R;

import java.util.List;

public class ViewHomeAdapter extends RecyclerView.Adapter<ViewHomeAdapter.ViewHolder> {
    Context context;
    List<ViewHomeModel> viewHomeModelList;

    public ViewHomeAdapter(Context context, List<ViewHomeModel> viewHomeModelList) {
        this.context = context;
        this.viewHomeModelList = viewHomeModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhome_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(viewHomeModelList.get(position).getImg_url()).into(holder.imageview);
//        Glide.with(context).load(viewHomeModelList.get(position).getImg_loc()).into(holder.loc);
//        Glide.with(context).load(viewHomeModelList.get(position).getMap()).into(holder.map);

        holder.name.setText(viewHomeModelList.get(position).getName());
        holder.address.setText(viewHomeModelList.get(position).getAddress());
        holder.description.setText(viewHomeModelList.get(position).getDescription());
        holder.txt.setText(viewHomeModelList.get(position).getText());


        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, BookingPlaceActivity.class);
                context.startActivity(intent);
            }
        });
//        holder.txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentObj = new Intent(Intent.ACTION_VIEW);
//                intentObj.setData(Uri.parse("https://www.google.com/maps/d/viewer?mid=19GmmDsf0ZrM4innqgkxCZcoNuog&hl=en&ll=11.3632715565516%2C78.33372545304171&z=8"));
//                context.startActivity(intentObj);
//            }
//        });
//        holder.map.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intentObj = new Intent(Intent.ACTION_VIEW);
//                intentObj.setData(Uri.parse("https://www.google.com/maps/place/Valparai,+Tamil+Nadu+642127/@10.3269732,76.9553967,15z/data=!3m1!4b1!4m5!3m4!1s0x3ba8279db1aa1b0f:0x86bc2b6e18667469!8m2!3d10.3269734!4d76.9553967"));
//                context.startActivity(intentObj);
//            }
//        });

    }


    @Override
    public int getItemCount() {
        return viewHomeModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView name,address,description,txt;
        Button book;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.view_img);
//            loc=itemView.findViewById(R.id.loc);
            name=itemView.findViewById(R.id.view_name);
            address=itemView.findViewById(R.id.view_address);
            description=itemView.findViewById(R.id.view_description);
            book=itemView.findViewById(R.id.check);
            txt=itemView.findViewById(R.id.gg);


//            map=itemView.findViewById(R.id.map);






        }
    }
}
