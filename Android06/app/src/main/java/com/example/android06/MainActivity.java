package com.example.android06;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnButton, btnNext, btnBottom;
    TextView tvDisplay;
    EditText etNumber;
    
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnButton = (Button)findViewById(R.id.btnButton);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnBottom = (Button) findViewById(R.id.btnBottom);

        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        etNumber = (EditText) findViewById(R.id.etNumber);

        btnButton.setOnClickListener(v -> {
            String inString = etNumber.getText().toString();
            tvDisplay.setText(inString);
        });
    }
}