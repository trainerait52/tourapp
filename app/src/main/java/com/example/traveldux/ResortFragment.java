package com.example.traveldux;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.traveldux.databinding.FragmentCabBinding;
import com.example.traveldux.databinding.FragmentResortBinding;


public class ResortFragment extends Fragment {
Button Athirapilly,Kumarakom,varkala,alapuzha,munnar,gavi;
    private FragmentResortBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentResortBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
Athirapilly=root.findViewById(R.id.Athirapilly);
Kumarakom=root.findViewById(R.id.Kumarakom);
varkala=root.findViewById(R.id.varkala);
        alapuzha=root.findViewById(R.id.alapuzha);
        munnar=root.findViewById(R.id.munnar);
        gavi=root.findViewById(R.id.gavi);
Athirapilly.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),AthirapillyResortsActivity.class);
        startActivity(intent);
    }
});
Kumarakom.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),KumarakomResortActivity.class);
        startActivity(intent);
    }
});
varkala.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),VarkalaResortActivity.class);
        startActivity(intent);
    }
});

        alapuzha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AlapuzhaResortsActivity.class);
                startActivity(intent);
            }
        });

        munnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),MunnarResortActivity.class);
                startActivity(intent);
            }
        });
        gavi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),GaviResortActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }


}