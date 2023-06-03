package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.traveldux.Adapter.AthirapillyResortAdapter;
import com.example.traveldux.Adapter.MunnarResortAdapter;
import com.example.traveldux.Models.AthriapillyResortModel;
import com.example.traveldux.Models.MunnarResortModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MunnarResortActivity extends AppCompatActivity {
    RecyclerView resrecycle;
    FirebaseFirestore db;


    //resort
    List<MunnarResortModel> munnarResortModels;
    MunnarResortAdapter munnarResortAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_munnar_resort);
        db=FirebaseFirestore.getInstance();
        resrecycle=findViewById(R.id.mresort_rec);

        //populrplaces
        resrecycle.setLayoutManager(new LinearLayoutManager(MunnarResortActivity.this,RecyclerView.VERTICAL,false));
        munnarResortModels=new ArrayList<>();
        munnarResortAdapter=new MunnarResortAdapter(MunnarResortActivity.this,munnarResortModels);
        resrecycle.setAdapter(munnarResortAdapter);

        db.collection("MunnarResorts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                MunnarResortModel model=document.toObject(MunnarResortModel.class);
                                munnarResortModels.add(model);
                                munnarResortAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(MunnarResortActivity.this,"error"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}