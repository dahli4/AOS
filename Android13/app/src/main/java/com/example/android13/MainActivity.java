package com.example.android13;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout = null;
    Button button1 =  null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        baseLayout = (LinearLayout) findViewById( R.id.baseLayout ) ;
        button1 = (Button) findViewById( R.id.button1 ) ;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item== null ) return false;
        if( item.getItemId() == R.id.itemBlue  ) {
            baseLayout.setBackgroundColor( Color.BLUE  );
        }else if( item.getItemId() == R.id.itemRed  ) {
            baseLayout.setBackgroundColor( Color.RED );
        }else if( item.getItemId() == R.id.itemGreen  ) {
            baseLayout.setBackgroundColor( Color.GREEN );
        }else if( item.getItemId() == R.id.btnRotate  ) {
            button1.setRotation(45);
        }else if( item.getItemId() == R.id.btnSubsize  ) {
            button1.setScaleX(3);
        }
        return false;
    }
}