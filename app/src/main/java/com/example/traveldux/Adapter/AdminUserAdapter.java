package com.example.traveldux.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldux.Models.AdminUserModel;
import com.example.traveldux.R;

import java.util.List;

public class AdminUserAdapter  extends RecyclerView.Adapter<AdminUserAdapter.ViewHolder> {


    Context context;
    List<AdminUserModel> adminModelList;

    public AdminUserAdapter(Context context, List<AdminUserModel> adminModelList) {
        this.context = context;
        this.adminModelList = adminModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adminviewuser_list,null));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdminUserModel adminModel=adminModelList.get(position);
        holder.email.setText(adminModel.getEmail());
        holder.name.setText(adminModel.getName());
        holder.password.setText(adminModel.getPassword());

    }

    @Override
    public int getItemCount() {
        return adminModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView email, name, password;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.uemail);
            name = itemView.findViewById(R.id.uname);
            password = itemView.findViewById(R.id.upassword);


        }
    }
}
