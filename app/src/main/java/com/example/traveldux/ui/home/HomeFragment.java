package com.example.traveldux.ui.home;

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

import com.example.traveldux.Adapter.PopularPlacesAdapter;
import com.example.traveldux.Models.PopularPlacesModel;
import com.example.traveldux.R;
import com.example.traveldux.databinding.FragmentHomeBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    RecyclerView poprecycle;
    FirebaseFirestore db;


    //populaarplaces
    List<PopularPlacesModel> popularPlacesModels;
    PopularPlacesAdapter popularPlacesAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db=FirebaseFirestore.getInstance();
        poprecycle=root.findViewById(R.id.pop_rec);

        //populrplaces
        poprecycle.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        popularPlacesModels=new ArrayList<>();
        popularPlacesAdapter=new PopularPlacesAdapter(getActivity(),popularPlacesModels);
        poprecycle.setAdapter(popularPlacesAdapter);

        db.collection("PopularPlaces")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                PopularPlacesModel model=document.toObject(PopularPlacesModel.class);
                                popularPlacesModels.add(model);
                                popularPlacesAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(),"error"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return root;
    }


}