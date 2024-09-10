package com.example.android03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pipa);
        TextView tvHello = (TextView)findViewById(R.id.tvHello);
        Button btnHello = (Button)findViewById(R.id.btnHello);

        btnHello.setOnClickListener(v -> {
            tvHello.setText(R.string.tv_output);
            Toast.makeText(getApplicationContext(),"버튼을 눌렀다!",Toast.LENGTH_LONG).show();
        });
    }
}