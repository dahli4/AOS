package com.example.android14;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    Button btnGoThird;
    PersonData personData;
    int age;
    String name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        age = intent.getIntExtra("Age", 0);
        name = intent.getStringExtra("Name");
        personData = (PersonData) intent.getSerializableExtra("Person");
        btnGoThird = (Button) findViewById(R.id.btnGoThird);

        Toast.makeText(this, "Person:age:" + personData.getAge()  + " :::Persion:name:"+personData.getName() , Toast.LENGTH_SHORT).show();

        btnGoThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}