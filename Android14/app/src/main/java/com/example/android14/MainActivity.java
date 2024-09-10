package com.example.android14;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnGoSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnGoSecond = (Button) findViewById(R.id.btnGoSecond);
        PersonData personData = new PersonData();
        personData.setAge(20);
        personData.setName("홍길동");

        btnGoSecond.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("Age",300);
            intent.putExtra("Name","강호동");
            intent.putExtra("Person", personData);
            startActivity(intent);
            finish();
        });
    }
}