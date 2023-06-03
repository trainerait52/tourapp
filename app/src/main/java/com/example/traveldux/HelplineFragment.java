package com.example.traveldux;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.traveldux.databinding.FragmentHelplineBinding;


public class HelplineFragment extends Fragment {

    Button helpline;
    private FragmentHelplineBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHelplineBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        helpline=root.findViewById(R.id.help);

        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number="1111222";
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });
        return  root;
    }

}