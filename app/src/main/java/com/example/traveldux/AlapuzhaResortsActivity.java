package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.traveldux.Adapter.AlapuzhaResortAdapter;
import com.example.traveldux.Adapter.AthirapillyResortAdapter;
import com.example.traveldux.Models.AlapuzhaResortModel;
import com.example.traveldux.Models.AthriapillyResortModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AlapuzhaResortsActivity extends AppCompatActivity {
    RecyclerView resrecycle;
    FirebaseFirestore db;


    //resort
    List<AlapuzhaResortModel> alapuzhaResortModels;
    AlapuzhaResortAdapter alapuzhaResortAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alapuzha_resorts);
        db=FirebaseFirestore.getInstance();
        resrecycle=findViewById(R.id.alresort_rec);

        //populrplaces
        resrecycle.setLayoutManager(new LinearLayoutManager(AlapuzhaResortsActivity.this,RecyclerView.VERTICAL,false));
        alapuzhaResortModels=new ArrayList<>();
        alapuzhaResortAdapter=new AlapuzhaResortAdapter(AlapuzhaResortsActivity.this,alapuzhaResortModels);
        resrecycle.setAdapter(alapuzhaResortAdapter);

        db.collection("AlapuzhaResorts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                AlapuzhaResortModel model=document.toObject(AlapuzhaResortModel.class);
                                alapuzhaResortModels.add(model);
                                alapuzhaResortAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(AlapuzhaResortsActivity.this,"error"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}