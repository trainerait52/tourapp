package com.example.traveldux.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldux.Models.AdminCustomerReviewModel;
import com.example.traveldux.R;

import java.util.List;

public class AdminCustomerReviewAdapter extends RecyclerView.Adapter<AdminCustomerReviewAdapter.ViewHolder> {


    Context context;
    List<AdminCustomerReviewModel> adminModelList;

    public AdminCustomerReviewAdapter(Context context, List<AdminCustomerReviewModel> adminModelList) {
        this.context = context;
        this.adminModelList = adminModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adminviewcustomerreview_list,null));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdminCustomerReviewModel adminModel=adminModelList.get(position);
        holder.name.setText(adminModel.getName());
        holder.num.setText(adminModel.getNum());
        holder.reviewsubmit.setText(adminModel.getReviewsubmit());
        holder.txtreview.setText(adminModel.getTxtreview());
    }

    @Override
    public int getItemCount() {
        return adminModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, num, reviewsubmit, txtreview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.crname);
            num = itemView.findViewById(R.id.crnum);
            reviewsubmit = itemView.findViewById(R.id.crreviewsub);
            txtreview = itemView.findViewById(R.id.crtxtreview);
        }
    }
}
