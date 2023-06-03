package com.example.traveldux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firebaseAuth = FirebaseAuth.getInstance();
        //start login activity after 2sec
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user==null){
//user not logged in start login activity
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    finish();
                }else {
//user is loggin
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();

                }

            }


        },2000);
    }
}