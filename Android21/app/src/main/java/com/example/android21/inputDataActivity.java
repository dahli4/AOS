package com.example.android21;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android21.db.MyDBHelper;

public class inputDataActivity extends AppCompatActivity {

    Button btnGoMain;
    Button btnSave;
    MyDBHelper myDBHelper;
    SQLiteDatabase sqlLite;
    EditText etId;
    EditText etName;
    EditText etEmail;
    EditText etBirthyear ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_data);
        setTitle("INPUT DATA");

        etId = (EditText) findViewById(R.id.etId);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etBirthyear = (EditText) findViewById(R.id.etBirthyear);

        myDBHelper = new MyDBHelper(this);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            String sql = "INSERT INTO userTBL( " +
                    "id ,name , email , birthyear" +
                    ") VALUES ( " +
                    "'"+etId.getText().toString()+"', " +
                    "'"+etName.getText().toString()+"'," +
                    "'"+etEmail.getText().toString()+"'," +
                    "'"+etBirthyear.getText().toString()+"'"+
                    "); ";
            sqlLite = myDBHelper.getWritableDatabase();
            sqlLite.execSQL(sql);
            sqlLite.close();
        });

        btnGoMain = (Button) findViewById(R.id.btnGoMain);
        btnGoMain.setOnClickListener(v -> {
            finish();

            etId.setText("");
            etName.setText("");
            etEmail.setText("");
            etBirthyear.setText("");
        });
    }
}