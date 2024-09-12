package com.example.android20;

import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    MyGalleryAdapter myAdapter;
    Gallery movieGallery;
ImageView ivPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ivPoster = (ImageView) findViewById(R.id.ivPoster);

        myAdapter = new MyGalleryAdapter();

        movieGallery = (Gallery) findViewById(R.id.movieGallery);
        movieGallery.setAdapter(myAdapter);

        movieGallery.setOnItemClickListener((parent, view, position, id) -> {
            Integer posterID = (Integer) parent.getItemAtPosition(position) ;
            ivPoster.setImageResource(posterID);
        });
    }
}