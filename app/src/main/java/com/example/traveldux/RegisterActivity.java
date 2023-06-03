package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.traveldux.Models.HelperClass;
import com.example.traveldux.Models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    Button signUp;
    EditText name, email, password;
    TextView signIn;
    FirebaseAuth auth;

    FirebaseDatabase database;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        signUp = findViewById(R.id.signup);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signIn = findViewById(R.id.sigin);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);


                createUser();
                progressBar.setVisibility(View.VISIBLE);


            }
        });
    }

    private void createUser() {
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        if (!Patterns.DOMAIN_NAME.matcher(userName).matches()) {
            Toast.makeText(this, "Invalid username Pattern...", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            Toast.makeText(this, "Invalid Email Pattern...", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "Enter Password...", Toast.LENGTH_SHORT).show();
            return; 
        }

//        if (TextUtils.isEmpty(userName)) {
//            Toast.makeText(RegisterActivity.this, "name is empty ", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (TextUtils.isEmpty(userEmail)) {
//            Toast.makeText(RegisterActivity.this, "email is empty ", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (TextUtils.isEmpty(userPassword)) {
//            Toast.makeText(RegisterActivity.this, "password is empty ", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (userPassword.length() < 6) {
//            Toast.makeText(RegisterActivity.this, "password length must be greater than 6 letter", Toast.LENGTH_SHORT).show();
//            return;
//        }
        //create user
        auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            UserModel model = new UserModel(userName, userEmail, userPassword);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(model);
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(RegisterActivity.this, "Registeration successfull", Toast.LENGTH_SHORT).show();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(RegisterActivity.this, "Error:" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}

