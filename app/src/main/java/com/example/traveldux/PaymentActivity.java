package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveldux.Models.PaymentsModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaymentActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference dref;
    EditText name, number, exp, cvc, amount;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        name = findViewById(R.id.cardname);
        number = findViewById(R.id.cardnumber);
        exp = findViewById(R.id.date);
        cvc = findViewById(R.id.cvc);
        amount = findViewById(R.id.cardamount);



        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mname = name.getText().toString();
                String mnumber = number.getText().toString();
                String mexp = exp.getText().toString();
                String mcvc = cvc.getText().toString();
                String mamount = amount.getText().toString();
                if (TextUtils.isEmpty(mname)) {
                    name.setError("name is must contain");
                    name.requestFocus();
                } else if (TextUtils.isEmpty(mnumber)) {
                    number.setError(" card number is must contain");
                    number.requestFocus();
                } else if (mnumber.length() != 16) {
                    number.setError("card number should be 16 digits");
                    number.requestFocus();
                }else if (TextUtils.isEmpty(mexp)) {
                    exp.setError("month/year is must contain");
                    exp.requestFocus();
                }else if (TextUtils.isEmpty(mcvc)) {
                    cvc.setError("cvc is must contain");
                    cvc.requestFocus();
                } else if (mcvc.length() != 3) {
                    cvc.setError("cvc number should be 3 digits");
                    cvc.requestFocus();
                }else if (TextUtils.isEmpty(mamount)) {
                    amount.setError("amount is must contain");
                    amount.requestFocus();
                }
//                if (!mname.isEmpty() && !mnumber.isEmpty() && !mexp.isEmpty() && !mcvc.isEmpty() && !mamount.isEmpty()) {
                   else{ PaymentsModel paymentsModel = new PaymentsModel(mname, mnumber, mexp, mcvc,mamount);
                    db = FirebaseDatabase.getInstance();
                    dref = db.getReference("Payments");
                    dref.child(mname).setValue(paymentsModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            name.setText("");
                            number.setText("");
                            exp.setText("");
                            cvc.setText("");
                            amount.setText("");

                            Toast.makeText(PaymentActivity.this, "Paymented Successfuly", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(PaymentActivity.this,PaymentSuccessActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}