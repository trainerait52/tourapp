package com.example.traveldux;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.traveldux.Adapter.RailAdapter;

import com.example.traveldux.Models.RailModel;
import com.example.traveldux.databinding.FragmentRailwayStationBinding;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class RailwayStationFragment extends Fragment {
    RecyclerView recyclerView;
    List<RailModel> railModel;
    RailAdapter railAdapter;

    FirebaseFirestore db;
   private FragmentRailwayStationBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRailwayStationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        db=FirebaseFirestore.getInstance();
        recyclerView=root.findViewById(R.id.railrecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        railModel=new ArrayList<>();
        railAdapter=new RailAdapter(getActivity(),railModel);
        recyclerView.setAdapter(railAdapter);


        db.collection("RailWayStation")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                RailModel Model=document.toObject(RailModel.class);
                                railModel.add(Model);
                                railAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        return root;
    }
}