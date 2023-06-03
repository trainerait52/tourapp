package com.example.traveldux;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class TourLogoActivity extends AppCompatActivity {
    private ImageSlider imageSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_logo);

        imageSlider=findViewById(R.id.imageslider);
        ArrayList<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://tse4.explicit.bing.net/th?id=OIP.Y_kvQAhhBocgfgQHrZdiQQHaG2&pid=Api&P=0", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://tse1.mm.bing.net/th?id=OIP.1alfQ7ts3chaIafeYV_eKQHaF7&pid=Api&P=0", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://tse2.mm.bing.net/th?id=OIP.naKo5Hm521fJPZZM0mP6GgHaHa&pid=Api&P=0", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://tse4.mm.bing.net/th?id=OIP.d-6Qq3NjsFuPLR8PNXT1iAHaHa&pid=Api&P=0", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://tse1.mm.bing.net/th?id=OIP.A7xR9oYnIomHKvfTmkOo_wHaGq&pid=Api&P=0", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);
    }

    public void next(View view) {
        Intent intent=new Intent(TourLogoActivity.this,LoginActivity.class);
        startActivity(intent);
    }

}