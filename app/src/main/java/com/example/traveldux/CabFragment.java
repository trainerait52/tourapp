package com.example.traveldux;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.example.traveldux.databinding.FragmentCabBinding;
import com.example.traveldux.databinding.FragmentMapBinding;


public class CabFragment extends Fragment {
    LottieAnimationView cab;
    private FragmentCabBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCabBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        cab=root.findViewById(R.id.taxi);
        cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj = new Intent(Intent.ACTION_VIEW);
                intentObj.setData(Uri.parse("https://book.olacabs.com/"));
                startActivity(intentObj);
            }
        });
        return root;
    }
}