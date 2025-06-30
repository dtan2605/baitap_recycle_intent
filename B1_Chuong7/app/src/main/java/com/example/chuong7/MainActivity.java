package com.example.chuong7;

import android.os.Bundle;

import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);

        String imageUrl = "https://picsum.photos/400";

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.loading)
                .error(R.drawable.error_image)
                .into(imageView);
    }
}