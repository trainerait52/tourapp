package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.traveldux.Adapter.AthirapillyResortAdapter;
import com.example.traveldux.Adapter.KumarakomResortAdapter;
import com.example.traveldux.Models.AthriapillyResortModel;
import com.example.traveldux.Models.KumarakomResortModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class KumarakomResortActivity extends AppCompatActivity {
    RecyclerView resrecycle;
    FirebaseFirestore db;


    // kumarakom resort
    List<KumarakomResortModel> kumarakomResortModels;
    KumarakomResortAdapter kumarakomResortAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumarakom_resort);

        db=FirebaseFirestore.getInstance();
        resrecycle=findViewById(R.id.kumresort_rec);

        //kumarakom
        resrecycle.setLayoutManager(new LinearLayoutManager(KumarakomResortActivity.this,RecyclerView.VERTICAL,false));
        kumarakomResortModels=new ArrayList<>();
        kumarakomResortAdapter=new KumarakomResortAdapter(KumarakomResortActivity.this,kumarakomResortModels);
        resrecycle.setAdapter(kumarakomResortAdapter);

        db.collection("KumarakomResorts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                KumarakomResortModel model=document.toObject(KumarakomResortModel.class);
                                kumarakomResortModels.add(model);
                                kumarakomResortAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(KumarakomResortActivity.this,"error"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}