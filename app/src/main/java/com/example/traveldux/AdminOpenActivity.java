package com.example.traveldux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminOpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_open);
    }

    public void bookinglist(View view) {
        Intent intent=new Intent(AdminOpenActivity.this,AdminBookingListViewActivity.class);
        startActivity(intent);
    }

    public void resorts(View view) {
        Intent intent=new Intent(AdminOpenActivity.this,AdminResortviewActivity.class);
        startActivity(intent);
    }

    public void payments(View view) {
        Intent intent=new Intent(AdminOpenActivity.this,AdminPaymentViewActivity.class);
        startActivity(intent);
    }

    public void user(View view) {
        Intent intent=new Intent(AdminOpenActivity.this,AdminViewUserActivity.class);
        startActivity(intent);
    }

    public void reviews(View view) {
        Intent intent=new Intent(AdminOpenActivity.this,AdminCustomerReviewActivity.class);
        startActivity(intent);
    }
}