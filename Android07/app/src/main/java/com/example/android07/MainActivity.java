package com.example.android07;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnSub, btnMul, btnDiv;
    EditText etFirst, etSecond;
    TextView tvResult;

    private String operate(EditText etFirst, EditText etSecond, int operate) {
        int iFirst = Integer.parseInt(etFirst.getText().toString());
        int iSecond = Integer.parseInt(etSecond.getText().toString());
        int iResult = 0;

        switch (operate) {
            case 1: iResult = iFirst + iSecond; break;
            case 2: iResult = iFirst - iSecond; break;
            case 3: iResult = iFirst * iSecond; break;
            case 4: iResult = iFirst / iSecond; break;
        }

        return "RESULT: "+iResult;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etFirst = (EditText) findViewById(R.id.etFirst);
        etSecond = (EditText) findViewById(R.id.etSecond);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> tvResult.setText(operate(etFirst, etSecond, 1)));

        btnSub = (Button) findViewById(R.id.btnSub);
        btnSub.setOnClickListener(v -> tvResult.setText(operate(etFirst, etSecond, 2)));

        btnMul = (Button) findViewById(R.id.btnMul);
        btnMul.setOnClickListener(v -> tvResult.setText(operate(etFirst, etSecond, 3)));

        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(v -> tvResult.setText(operate(etFirst, etSecond, 4)));
    }
}