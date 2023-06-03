package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.traveldux.Adapter.AthirapillyResortAdapter;
import com.example.traveldux.Adapter.VarkalaResortAdapter;
import com.example.traveldux.Models.AthriapillyResortModel;
import com.example.traveldux.Models.VarkalaResortModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class VarkalaResortActivity extends AppCompatActivity {
    RecyclerView resrecycle;
    FirebaseFirestore db;


    //resort
    List<VarkalaResortModel> varkalaResortModels;
    VarkalaResortAdapter varkalaResortAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varkala_resort);
        db=FirebaseFirestore.getInstance();
        resrecycle=findViewById(R.id.vresort_rec);

        //populrplaces
        resrecycle.setLayoutManager(new LinearLayoutManager(VarkalaResortActivity.this,RecyclerView.VERTICAL,false));
        varkalaResortModels=new ArrayList<>();
        varkalaResortAdapter=new VarkalaResortAdapter(VarkalaResortActivity.this,varkalaResortModels);
        resrecycle.setAdapter(varkalaResortAdapter);

        db.collection("VarkalaResorts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                VarkalaResortModel model=document.toObject(VarkalaResortModel.class);
                                varkalaResortModels.add(model);
                                varkalaResortAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(VarkalaResortActivity.this,"error"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}