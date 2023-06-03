package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.traveldux.Adapter.ViewHomeAdapter;
import com.example.traveldux.Models.ViewHomeModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ViewHomeActivity extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    ViewHomeAdapter viewHomeAdapter;
    List<ViewHomeModel> viewHomeModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_home);
        firestore = FirebaseFirestore.getInstance();
        String type = getIntent().getStringExtra("type");
        recyclerView = findViewById(R.id.viewrecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewHomeModels = new ArrayList<>();
        viewHomeAdapter = new ViewHomeAdapter(this, viewHomeModels);
        recyclerView.setAdapter(viewHomeAdapter);
        ///aatthirapilly
        if (type != null && type.equalsIgnoreCase("Athirappilly")) {
            firestore.collection("ViewHome").whereEqualTo("type", "Athirappilly").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewHomeModel model = documentSnapshot.toObject(ViewHomeModel.class);
                        viewHomeModels.add(model);
                        viewHomeAdapter.notifyDataSetChanged();

                    }
                }
            });
        }

        ///alapuzha
        if (type != null && type.equalsIgnoreCase("Alapuzha")) {
            firestore.collection("ViewHome").whereEqualTo("type", "Alapuzha").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewHomeModel model = documentSnapshot.toObject(ViewHomeModel.class);
                        viewHomeModels.add(model);
                        viewHomeAdapter.notifyDataSetChanged();

                    }
                }
            });
        }
        ///Varkala
        if (type != null && type.equalsIgnoreCase("Varkala")) {
            firestore.collection("ViewHome").whereEqualTo("type", "Varkala").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewHomeModel model = documentSnapshot.toObject(ViewHomeModel.class);
                        viewHomeModels.add(model);
                        viewHomeAdapter.notifyDataSetChanged();

                    }
                }
            });
        }
        ///gavi kerala
        if (type != null && type.equalsIgnoreCase("Gavi")) {
            firestore.collection("ViewHome").whereEqualTo("type", "Gavi").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewHomeModel model = documentSnapshot.toObject(ViewHomeModel.class);
                        viewHomeModels.add(model);
                        viewHomeAdapter.notifyDataSetChanged();

                    }
                }
            });
        }
        ///munnar
        if (type != null && type.equalsIgnoreCase("munnar")) {
            firestore.collection("ViewHome").whereEqualTo("type", "munnar").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewHomeModel model = documentSnapshot.toObject(ViewHomeModel.class);
                        viewHomeModels.add(model);
                        viewHomeAdapter.notifyDataSetChanged();

                    }
                }
            });
        }


        ///kumarakom,kerala
        if (type != null && type.equalsIgnoreCase("Kumarakom")) {
            firestore.collection("ViewHome").whereEqualTo("type", "Kumarakom").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()) {
                        ViewHomeModel model = documentSnapshot.toObject(ViewHomeModel.class);
                        viewHomeModels.add(model);
                        viewHomeAdapter.notifyDataSetChanged();

                    }
                }
            });
        }


    }
}