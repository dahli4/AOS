package com.example.android08;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox cbStart;
    TextView tvQuestion;
    RadioGroup rgPet;
    Button btnSelect;
    ImageView imgPet;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        rgPet = (RadioGroup) findViewById(R.id.rgPet);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        imgPet = (ImageView) findViewById(R.id.imgPet);

        cbStart = (CheckBox) findViewById(R.id.cbStart);
        cbStart.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                tvQuestion.setVisibility(View.VISIBLE);
                rgPet.setVisibility(View.VISIBLE);
                btnSelect.setVisibility(View.VISIBLE);
                imgPet.setVisibility(View.VISIBLE);
            } else {
                tvQuestion.setVisibility(View.INVISIBLE);
                rgPet.setVisibility(View.INVISIBLE);
                btnSelect.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
            }
        });

        btnSelect.setOnClickListener(v -> {
            int selectRadioButton = rgPet.getCheckedRadioButtonId();
            if (selectRadioButton == R.id.rbDog) {
                imgPet.setImageResource(R.drawable.dog1);
            } else if (selectRadioButton == R.id.rbCat) {
                imgPet.setImageResource(R.drawable.cat);
            } else if (selectRadioButton == R.id.rbRabbit) {
                imgPet.setImageResource(R.drawable.rabbit);
            }
        });
    }
}