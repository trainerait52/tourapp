package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText loginUsername, loginPassword;
    private EditText editTextemail, editTextpassword;
    private TextView forgotpassword, register, admin;
    private Button login;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextemail = (EditText) findViewById(R.id.emaillog);
        editTextpassword = (EditText) findViewById(R.id.passwordlog);
//        forgotpassword = (TextView) findViewById(R.id.forgotpass);
        register = (TextView) findViewById(R.id.registerlog);
        login = (Button) findViewById(R.id.loginbutton);
        firebaseAuth = FirebaseAuth.getInstance();
        admin = findViewById(R.id.admin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, AdminLoginActivity.class);
                startActivity(intent);
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("please Wait");
        progressDialog.setCanceledOnTouchOutside(false);


//        forgotpassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//
//            }
//        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();

            }
        });


    }

    private String email, password;

    private void loginUser() {

        email = editTextemail.getText().toString().trim();
        password = editTextpassword.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Invalid Email Pattern...", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Enter Password...", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Logging In...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
//login successfully
                        makeMeonline();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
//login failed
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                    }
                });


    }

    private void makeMeonline() {

//after logging in,make useronline
        progressDialog.setMessage("Checking Registeration..");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("online", "ture");

        //update Value to db
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
        reference.child(firebaseAuth.getUid()).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
//Update successfully

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
//failed updating
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Failed Updation", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
