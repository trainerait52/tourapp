package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.traveldux.Models.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookingPlaceActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference dref;
    EditText name, days, rooms, members, date, time, amount;
    Button booking,cancel;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_place);
        name = findViewById(R.id.uname);
        days = findViewById(R.id.days);
        rooms = findViewById(R.id.rooms);
        members = findViewById(R.id.members);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        amount = findViewById(R.id.amount);
cancel=findViewById(R.id.cancel1);

        booking = findViewById(R.id.book);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(date);
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(time);
            }
        });
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mname = name.getText().toString();
                String mdays = days.getText().toString();
                String mrooms = rooms.getText().toString();
                String mmembers = members.getText().toString();
                String mdate = date.getText().toString();
                String mtime = time.getText().toString();
                String mamount = amount.getText().toString();
                String mbook = booking.getText().toString();
                if (TextUtils.isEmpty(mname)) {
                    name.setError("name is must contain");
                    name.requestFocus();
                } else if (TextUtils.isEmpty(mdays)) {
                    days.setError("day is must contain");
                    days.requestFocus();
                } else if (TextUtils.isEmpty(mrooms)) {
                    rooms.setError("rooms is must contain");
                    rooms.requestFocus();
                } else if (TextUtils.isEmpty(mmembers)) {
                    members.setError("members is must contain");
                    members.requestFocus();
                } else if (TextUtils.isEmpty(mdate)) {
                    date.setError("date is required");
                    date.requestFocus();
                } else if (TextUtils.isEmpty(mtime)) {
                    time.setError("time is required");
                    time.requestFocus();
                } else if (TextUtils.isEmpty(mamount)) {
                    amount.setError("amount is must contain");
                    amount.requestFocus();
                } else if (mbook.isEmpty()) {
                    booking.setError("please enter above details");
                    booking.requestFocus();
                }
//                if (!mname.isEmpty() && !mdays.isEmpty() && !mrooms.isEmpty() && !mmembers.isEmpty() && !mdate.isEmpty() && !mtime.isEmpty() && !mamount.isEmpty()) {
                else {
                    Users users = new Users(mname, mdays, mrooms, mmembers, mdate, mtime, mamount);
                    db = FirebaseDatabase.getInstance();
                    dref = db.getReference("Booking List");
                    dref.child(mname).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            name.setText("");
                            days.setText("");
                            rooms.setText("");
                            members.setText("");
                            date.setText("");
                            time.setText("");
                            amount.setText("");

                            Toast.makeText(BookingPlaceActivity.this, "successfully Booked", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(BookingPlaceActivity.this, PaymentActivity.class);
                            startActivity(intent);

                        }
                    });
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mname = name.getText().toString();
//                String mdays = days.getText().toString();
//                String mrooms = rooms.getText().toString();
//                String mmembers = members.getText().toString();
//                String mdate = date.getText().toString();
//                String mtime = time.getText().toString();
//                String mamount = amount.getText().toString();
//                String mbook = booking.getText().toString();
                if (!mname.isEmpty()){

                    deleteData(mname);
//                    deleteData(mdays);
//                    deleteData(mrooms);
//                    deleteData(mmembers);
//                    deleteData(mdate);
//                    deleteData(mtime);
//                    deleteData(mamount);



                }else{

                    Toast.makeText(BookingPlaceActivity.this,"Please Enter Username",Toast.LENGTH_SHORT).show();
                }


            }

        });
    }

    private void deleteData(String mname) {
        reference = FirebaseDatabase.getInstance().getReference("Booking List");
        reference.child(mname).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){

                    Toast.makeText(BookingPlaceActivity.this,"Successfuly Deleted",Toast.LENGTH_SHORT).show();
                    name.setText("");


                }else {

                    Toast.makeText(BookingPlaceActivity.this,"Failed",Toast.LENGTH_SHORT).show();


                }

            }
        });
    }

    private void showTimeDialog(EditText time) {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm");
                time.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new TimePickerDialog(BookingPlaceActivity.this, timeSetListener, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),
                false).show();
    }

    private void showDateDialog(EditText date) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
                date.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        new DatePickerDialog(BookingPlaceActivity.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)
                , calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    }
