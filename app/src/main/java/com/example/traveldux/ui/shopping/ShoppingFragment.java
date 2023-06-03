package com.example.traveldux.ui.shopping;

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

import com.example.traveldux.Adapter.ShoppingAdapter;
import com.example.traveldux.Models.ShoppingModel;
import com.example.traveldux.R;
import com.example.traveldux.databinding.FragmentShoppingBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment {

    RecyclerView shoprecyclerView;
    List<ShoppingModel> shoppingModels;
    ShoppingAdapter shoppingAdapter;

    FirebaseFirestore db;
    private FragmentShoppingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentShoppingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db=FirebaseFirestore.getInstance();
        shoprecyclerView=root.findViewById(R.id.shpping_recycle);
        shoprecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        shoppingModels=new ArrayList<>();
        shoppingAdapter=new ShoppingAdapter(getActivity(),shoppingModels);
        shoprecyclerView.setAdapter(shoppingAdapter);



        db.collection("Shopping")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                ShoppingModel Model=document.toObject(ShoppingModel.class);
                                shoppingModels.add(Model);
                                shoppingAdapter.notifyDataSetChanged();
                            }
                        } else {
                            Toast.makeText(getActivity(), "Error"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return root;
    }


}