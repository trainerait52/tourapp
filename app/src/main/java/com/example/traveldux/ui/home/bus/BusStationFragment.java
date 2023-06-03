package com.example.traveldux.ui.home.bus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveldux.Adapter.BusAdapter;
import com.example.traveldux.Models.BusModel;
import com.example.traveldux.R;
import com.example.traveldux.databinding.FragmentBusstationBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class BusStationFragment extends Fragment {

    RecyclerView busrecyclerView;
    List<BusModel> busModels;
    BusAdapter busAdapter;

    FirebaseFirestore db;
    private FragmentBusstationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentBusstationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        db=FirebaseFirestore.getInstance();
        busrecyclerView=root.findViewById(R.id.busrecycle);
        busrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        busModels=new ArrayList<>();
        busAdapter=new BusAdapter(getActivity(),busModels);
        busrecyclerView.setAdapter(busAdapter);



        db.collection("BusStations")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                BusModel Model=document.toObject(BusModel.class);
                                busModels.add(Model);
                                busAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        return root;
    }


}