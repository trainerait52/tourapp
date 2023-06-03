package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traveldux.Adapter.AdminUserAdapter;
import com.example.traveldux.Models.AdminUserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminViewUserActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private  final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");
    private  final List<AdminUserModel> adminModels=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_user);
        recyclerView=findViewById(R.id.urecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(AdminViewUserActivity.this));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adminModels.clear();

                for (DataSnapshot users:snapshot.getChildren()){
                    if (users.hasChild("email")&&users.hasChild("name")
                            && users.hasChild("password")
                    ){

                        final  String getEmail=users.child("email").getValue(String.class);
                        final  String getName=users.child("name").getValue(String.class);
                        final  String getPassword=users.child("password").getValue(String.class);



                        AdminUserModel model=new AdminUserModel(getEmail,getName,
                                getPassword);
                        adminModels.add(model);

                    }

                }
                recyclerView.setAdapter(new AdminUserAdapter(AdminViewUserActivity.this,adminModels));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}