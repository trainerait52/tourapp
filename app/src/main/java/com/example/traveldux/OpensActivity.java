package com.example.traveldux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class OpensActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opens);


    }

    public void tourgirl(View view) {
        Intent mainIntent = new Intent(OpensActivity.this, MainActivity.class);
        startActivity(mainIntent);
    }
}