package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.traveldux.Adapter.AthirapillyResortAdapter;
import com.example.traveldux.Adapter.GaviResortAdapter;
import com.example.traveldux.Models.AthriapillyResortModel;
import com.example.traveldux.Models.GaviResortModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class GaviResortActivity extends AppCompatActivity {
    RecyclerView resrecycle;
    FirebaseFirestore db;


    //resort
    List<GaviResortModel> gaviResortModels;
    GaviResortAdapter gaviResortAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gavi_resort);

        db=FirebaseFirestore.getInstance();
        resrecycle=findViewById(R.id.gaviresort_rec);

        //populrplaces
        resrecycle.setLayoutManager(new LinearLayoutManager(GaviResortActivity.this,RecyclerView.VERTICAL,false));
        gaviResortModels=new ArrayList<>();
        gaviResortAdapter=new GaviResortAdapter(GaviResortActivity.this,gaviResortModels);
        resrecycle.setAdapter(gaviResortAdapter);

        db.collection("GaviResorts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                GaviResortModel model=document.toObject(GaviResortModel.class);
                                gaviResortModels.add(model);
                                gaviResortAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(GaviResortActivity.this,"error"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}