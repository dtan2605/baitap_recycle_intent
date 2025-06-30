package com.example.intent_themtinhnang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:0123456789")); // Số điện thoại mẫu
                startActivity(callIntent);
            }
        });
        Button btnMap = findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = "geo:0,0?q=Cơm+tấm+Kiều+Giang"; // Địa điểm mẫu
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        Button btnWeb = findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://comtamkieugiang.vn/"; // URL mẫu
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(webIntent);
            }
        });

        SharedPreferences prefs = getSharedPreferences("LastViewedFood",MODE_PRIVATE);
        SharedPreferences.Editor editor= prefs.edit();
        editor.putString("lastFoodName", food.getName());
        editor.apply();
    }
}
