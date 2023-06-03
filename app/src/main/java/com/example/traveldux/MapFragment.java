package com.example.traveldux;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.example.traveldux.databinding.FragmentBusstationBinding;
import com.example.traveldux.databinding.FragmentMapBinding;

public class MapFragment extends Fragment {

LottieAnimationView map;
    private FragmentMapBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMapBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        map=root.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentObj = new Intent(Intent.ACTION_VIEW);
                intentObj.setData(Uri.parse("https://www.google.co.in/maps/@10.54063,76.1283185,7z"));
                startActivity(intentObj);
            }
        });

        return  root;
    }
}