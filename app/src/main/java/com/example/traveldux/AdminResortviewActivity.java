package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traveldux.Adapter.AdminResorttListAdapter;
import com.example.traveldux.Models.AdminResortListModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminResortviewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private  final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Booking Restaurent List");
    private  final List<AdminResortListModel> adminModels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_resortview);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AdminResortviewActivity.this));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adminModels.clear();

                for (DataSnapshot BookingRestaurentList:snapshot.getChildren()){
                    if (BookingRestaurentList.hasChild("amount")&& BookingRestaurentList.hasChild("date")&& BookingRestaurentList.hasChild("members")&& BookingRestaurentList.hasChild("name")&& BookingRestaurentList.hasChild("tables")&& BookingRestaurentList.hasChild("time")){

                        final  String getAmount=BookingRestaurentList.child("amount").getValue(String.class);
                        final  String getDate=BookingRestaurentList.child("date").getValue(String.class);
                        final  String getMembers=BookingRestaurentList.child("members").getValue(String.class);
                        final  String getName=BookingRestaurentList.child("name").getValue(String.class);
                        final  String getTables=BookingRestaurentList.child("tables").getValue(String.class);
                        final  String getTime=BookingRestaurentList.child("time").getValue(String.class);


                        AdminResortListModel model=new AdminResortListModel(getAmount,getDate,getMembers,getName,getTables,getTime);
                        adminModels.add(model);

                    }

                }
                recyclerView.setAdapter(new AdminResorttListAdapter(AdminResortviewActivity.this,adminModels));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}