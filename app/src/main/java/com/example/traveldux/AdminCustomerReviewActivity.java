package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traveldux.Adapter.AdminCustomerReviewAdapter;
import com.example.traveldux.Models.AdminCustomerReviewModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminCustomerReviewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private  final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("CustomerReview");
    private  final List<AdminCustomerReviewModel> adminModels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_customer_review);
        recyclerView=findViewById(R.id.crrecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AdminCustomerReviewActivity.this));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adminModels.clear();

                for (DataSnapshot CustomerReview:snapshot.getChildren()){
                    if (CustomerReview.hasChild("name")&&CustomerReview.hasChild("num")
                            && CustomerReview.hasChild("reviewsubmit") &&CustomerReview.hasChild("txtreview")
                    ){

                        final String getName=CustomerReview.child("name").getValue(String.class);
                        final String getNum=CustomerReview.child("num").getValue(String.class);
                        final String getReviewsubmit=CustomerReview.child("reviewsubmit").getValue(String.class);
                        final String getTxtreview=CustomerReview.child("txtreview").getValue(String.class);


                        AdminCustomerReviewModel model=new AdminCustomerReviewModel(getName,getNum,
                                getReviewsubmit,getTxtreview);
                        adminModels.add(model);

                    }

                }
                recyclerView.setAdapter(new AdminCustomerReviewAdapter(AdminCustomerReviewActivity.this,adminModels));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}