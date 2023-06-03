package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traveldux.Adapter.AdminPaymentListAdapter;
import com.example.traveldux.Models.AdminPaymentListModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminPaymentViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private  final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Payments");
    private  final List<AdminPaymentListModel> adminModels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_payment_view);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AdminPaymentViewActivity.this));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adminModels.clear();

                for (DataSnapshot Payments:snapshot.getChildren()){
                    if (Payments.hasChild("amount")&& Payments.hasChild("cvc")&& Payments.hasChild("exp")&& Payments.hasChild("name")&& Payments.hasChild("number")){

                        final  String getAmount=Payments.child("amount").getValue(String.class);
                        final  String getCvc=Payments.child("cvc").getValue(String.class);
                        final  String getExp=Payments.child("exp").getValue(String.class);
                        final  String getName=Payments.child("name").getValue(String.class);
                        final  String getNumber=Payments.child("number").getValue(String.class);


                        AdminPaymentListModel model=new AdminPaymentListModel(getAmount,getCvc,getExp,getName,getNumber);
                        adminModels.add(model);

                    }

                }
                recyclerView.setAdapter(new AdminPaymentListAdapter(AdminPaymentViewActivity.this,adminModels));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}