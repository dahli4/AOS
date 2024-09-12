package com.example.android19;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Integer[] posterID = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
            R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
            R.drawable.mov16, R.drawable.mov17, R.drawable.mov18, R.drawable.mov19, R.drawable.mov20,
            R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
            R.drawable.mov26, R.drawable.mov27, R.drawable.mov28, R.drawable.mov29, R.drawable.mov30,
    };
    GridView gvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("Movie Poster");

        GridAdapter myAdater = new GridAdapter();
        addAllPosterData(myAdater, posterID);
        gvMovie = (GridView) findViewById(R.id.gvMovie);
        gvMovie.setAdapter(myAdater);

        gvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Integer posterID = (Integer) parent.getItemAtPosition(position) ;

                View dialogView = (View) View.inflate(
                        MainActivity.this, R.layout.layout_dialog, null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);

                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivBigPoster);

                ivPoster.setImageResource(posterID);
                dlg.setTitle("큰 포스터");
                dlg.setIcon(R.drawable.ic_launcher);
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });
    }

    private void addAllPosterData(GridAdapter myAdapter, Integer[] posterID) {
        for (int index = 0; index < posterID.length; index++) {
            myAdapter.addOneItem(posterID[index]);
        }
    }
}