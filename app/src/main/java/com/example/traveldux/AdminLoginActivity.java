package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity {
    private EditText mEmail , mPass;
    private TextView mTextView,signup;
    private Button signInBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        mEmail = findViewById(R.id.adminemail_signin);
        mPass = findViewById(R.id.adminpasssignin);
        signInBtn = findViewById(R.id.adminsingin_btn);
        mTextView = findViewById(R.id.textView2);
        signup=findViewById(R.id.admin);

        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminLoginActivity.this,AdminRegisterActivity.class);
                startActivity(intent);

            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminLoginActivity.this , AdminRegisterActivity.class));
            }
        });
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

    }
    private void loginUser(){
        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

//        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
        if (mEmail.getText().toString().equals("admin1001@gmail.com")&& mPass.getText().toString().equals("admin@1001")){
            if (!pass.isEmpty()){
                mAuth.signInWithEmailAndPassword(email , pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(AdminLoginActivity.this, "Login Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(AdminLoginActivity.this , AdminOpenActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(AdminLoginActivity.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
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