package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.traveldux.Adapter.AthirapillyResortAdapter;
import com.example.traveldux.Adapter.PopularPlacesAdapter;
import com.example.traveldux.Models.AthriapillyResortModel;
import com.example.traveldux.Models.PopularPlacesModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class AthirapillyResortsActivity extends AppCompatActivity {
    RecyclerView resrecycle;
    FirebaseFirestore db;


    //resort
    List<AthriapillyResortModel> athriapillyResortModels;
    AthirapillyResortAdapter athirapillyResortAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athirapilly_resorts);

        db=FirebaseFirestore.getInstance();
        resrecycle=findViewById(R.id.resort_rec);

        //populrplaces
        resrecycle.setLayoutManager(new LinearLayoutManager(AthirapillyResortsActivity.this,RecyclerView.VERTICAL,false));
        athriapillyResortModels=new ArrayList<>();
        athirapillyResortAdapter=new AthirapillyResortAdapter(AthirapillyResortsActivity.this,athriapillyResortModels);
        resrecycle.setAdapter(athirapillyResortAdapter);

        db.collection("AthirapillyResorts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                AthriapillyResortModel model=document.toObject(AthriapillyResortModel.class);
                                athriapillyResortModels.add(model);
                                athirapillyResortAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(AthirapillyResortsActivity.this,"error"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}