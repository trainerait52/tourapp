package com.example.traveldux;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;
import com.example.traveldux.databinding.FragmentFeedbackBinding;
import com.example.traveldux.databinding.FragmentMapBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FeedbackFragment extends Fragment {

LottieAnimationView animationView;
    private FragmentFeedbackBinding binding;
    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFeedbackBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        animationView=root.findViewById(R.id.animationView);
        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),FeedBackActivity.class);
                startActivity(intent);
            }
        });
        return  root;
    }
}