package com.example.traveldux;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.traveldux.Models.ReviewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBackActivity extends AppCompatActivity {
    FirebaseDatabase db;
    DatabaseReference dref;
    EditText num ,txtreview ,name;
    Button reviewsubmit,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        name=findViewById(R.id.names);
        num = findViewById(R.id.num);
        txtreview = findViewById(R.id.txtreview);
        reviewsubmit = findViewById(R.id.reviewsub);
// status=findViewById(R.id.reviewstatus);
// status.setOnClickListener(new View.OnClickListener() {
// @Override
// public void onClick(View v) {
// Intent intent=new Intent(ReviewActivity.this,StatusActivity.class);
// startActivity(intent);
// }
// });
        reviewsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mname = name.getText().toString();
                String mnum = num.getText().toString();
                String mtxtreview = txtreview.getText().toString();
                String mreviewsub = reviewsubmit.getText().toString();

                if ( !mnum.isEmpty() && !mtxtreview.isEmpty() && !mreviewsub.isEmpty()) {
                    ReviewModel reviewModel = new ReviewModel(mname, mnum, mtxtreview, mreviewsub);
                    db = FirebaseDatabase.getInstance();
                    dref = db.getReference("CustomerReview");
                    dref.child(mname).setValue(reviewModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            name.setText("");
                            num.setText("");
                            txtreview.setText("");
// reviewsubmit.setText("");


                            Toast.makeText(FeedBackActivity.this, "review submitted successfully", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}