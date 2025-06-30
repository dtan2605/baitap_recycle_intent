package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class DetailActivity extends AppCompatActivity{
    ImageView detailImageView;
    TextView detailTextView;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImageView= findViewById(R.id.detaiImageView);
        detailTextView= findViewById(R.id.detailTextView);

        Food food = getIntent().getParcelableExtra("foodItem");

        detailImageView.setImageResource(food.getImageResId());

        String detailText = "Tên món ăn:" + food.getName() +
                            "\nMô tả:" + food.getDescription() +
                            "\nGía:" + food.getPrice() +"VNĐ";
        detailTextView.setText(detailText);

        Button orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(v ->{
            Toast.makeText(this, "Bạn đã gọi món:" + food.getName(), Toast.LENGTH_SHORT).show();

            SharedPreferences prefs=getSharedPreferences("OrderedFood",MODE_PRIVATE);
            SharedPreferences.Editor editor=prefs.edit();
            editor.putString("orderedFoodName",food.getName());
            editor.apply();
        });
        SharedPreferences prefs = getSharedPreferences("LastViewedFood",MODE_PRIVATE);
        SharedPreferences.Editor editor= prefs.edit();
        editor.putString("lastFoodName", food.getName());
        editor.apply();
    }
}
