package com.example.traveldux.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldux.Models.AdminResortListModel;
import com.example.traveldux.R;

import java.util.List;

public class AdminResorttListAdapter extends RecyclerView.Adapter<AdminResorttListAdapter.ViewHolder> {


    Context context;
    List<AdminResortListModel> adminModelList;

    public AdminResorttListAdapter(Context context, List<AdminResortListModel> adminModelList) {
        this.context = context;
        this.adminModelList = adminModelList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_resortlist_viewlist,null));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdminResortListModel adminModel=adminModelList.get(position);
        holder.amount.setText(adminModel.getAmount());
        holder.date.setText(adminModel.getDate());
        holder.members.setText(adminModel.getMembers());
        holder.name.setText(adminModel.getName());
        holder.tables.setText(adminModel.getTables());
        holder.time.setText(adminModel.getTime());
    }

    @Override
    public int getItemCount() {
        return adminModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount, date, members, name, tables, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.txtamount);
            date = itemView.findViewById(R.id.txtdate);
            members = itemView.findViewById(R.id.txtmembers);
            name = itemView.findViewById(R.id.txtname);
            tables = itemView.findViewById(R.id.txttables);
            time = itemView.findViewById(R.id.txttime);

        }
    }
}
