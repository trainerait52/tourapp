package com.example.traveldux.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldux.Models.AdminPaymentListModel;
import com.example.traveldux.R;

import java.util.List;

public class AdminPaymentListAdapter extends RecyclerView.Adapter<AdminPaymentListAdapter.ViewHolder> {


    Context context;
    List<AdminPaymentListModel> adminModelList;

    public AdminPaymentListAdapter(Context context, List<AdminPaymentListModel> adminModelList) {
        this.context = context;
        this.adminModelList = adminModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_payment_viewlist,null));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdminPaymentListModel adminModel=adminModelList.get(position);
        holder.amount.setText(adminModel.getAmount());
        holder.cvc.setText(adminModel.getCvc());
        holder.exp.setText(adminModel.getExp());
        holder.name.setText(adminModel.getName());
        holder.number.setText(adminModel.getNumber());
    }

    @Override
    public int getItemCount() {
        return adminModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView amount, cvc, exp, name, number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.txamount);
            cvc = itemView.findViewById(R.id.txcvc);
            exp = itemView.findViewById(R.id.txexp);
            name = itemView.findViewById(R.id.txname);
            number = itemView.findViewById(R.id.txnumber);

        }
    }
}
