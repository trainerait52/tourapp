package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminRegisterActivity extends AppCompatActivity {
    private EditText mEmail , mPass;
    private TextView mTextView ,signin;
    private Button signUpBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);
        mEmail = findViewById(R.id.ademail);
        mPass = findViewById(R.id.adpassword);
        mTextView = findViewById(R.id.txt);
        signUpBtn = findViewById(R.id.adsignup);
        signin=findViewById(R.id.adsigin);
        mAuth = FirebaseAuth.getInstance();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminRegisterActivity.this,AdminLoginActivity.class);
                startActivity(intent);

            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminRegisterActivity.this , AdminLoginActivity.class));
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }
    private void createUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (!pass.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(AdminRegisterActivity.this, "Registered Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AdminRegisterActivity.this , AdminLoginActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AdminRegisterActivity.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }else{
                mPass.setError("Empty Fields Are not Allowed");
            }
        }else if(email.isEmpty()){
            mEmail.setError("Empty Fields Are not Allowed");
        }else{
            mEmail.setError("Pleas Enter Correct Email");
        }
    }
}