package com.example.traveldux.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldux.Models.AdminBookingListModel;
import com.example.traveldux.R;

import java.util.List;

public class AdminBookingListAdapter extends RecyclerView.Adapter<AdminBookingListAdapter.ViewHolder> {


    Context context;
    List<AdminBookingListModel> adminModelList;

    public AdminBookingListAdapter(Context context, List<AdminBookingListModel> adminModelList) {
        this.context = context;
        this.adminModelList = adminModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_bookinglist_viewlist,null));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdminBookingListModel adminModel=adminModelList.get(position);
        holder.amount.setText(adminModel.getAmount());
        holder.date.setText(adminModel.getDate());
        holder.days.setText(adminModel.getDays());
        holder.members.setText(adminModel.getMembers());
        holder.name.setText(adminModel.getName());
        holder.rooms.setText(adminModel.getRooms());
        holder.time.setText(adminModel.getTime());
    }

    @Override
    public int getItemCount() {
        return adminModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount, date, days, members, name, rooms, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.textamount);
            date = itemView.findViewById(R.id.textdate);
            days = itemView.findViewById(R.id.textdays);
            members = itemView.findViewById(R.id.textmembers);
            name = itemView.findViewById(R.id.textname);
            rooms = itemView.findViewById(R.id.textrooms);
            time = itemView.findViewById(R.id.texttime);

        }
    }
}
