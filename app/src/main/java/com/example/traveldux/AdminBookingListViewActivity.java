package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traveldux.Adapter.AdminBookingListAdapter;
import com.example.traveldux.Models.AdminBookingListModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminBookingListViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private  final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Booking List");
    private  final List<AdminBookingListModel> adminModels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_booking_list_view);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AdminBookingListViewActivity.this));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adminModels.clear();

                for (DataSnapshot BookingList:snapshot.getChildren()){
                    if (BookingList.hasChild("amount")&& BookingList.hasChild("date")&& BookingList.hasChild("days")&& BookingList.hasChild("members")&& BookingList.hasChild("name")&& BookingList.hasChild("rooms")&& BookingList.hasChild("time")){

                        final  String getAmount=BookingList.child("amount").getValue(String.class);
                        final  String getDate=BookingList.child("date").getValue(String.class);
                        final  String getDays=BookingList.child("days").getValue(String.class);
                        final  String getMembers=BookingList.child("members").getValue(String.class);
                        final  String getName=BookingList.child("name").getValue(String.class);
                        final  String getRooms=BookingList.child("rooms").getValue(String.class);
                        final  String getTime=BookingList.child("time").getValue(String.class);


                        AdminBookingListModel model=new AdminBookingListModel(getAmount,getDate,getDays,getMembers,getName,getRooms,getTime);
                        adminModels.add(model);

                    }

                }
                recyclerView.setAdapter(new AdminBookingListAdapter(AdminBookingListViewActivity.this,adminModels));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}