package com.example.android21;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android21.db.MyDBHelper;

public class MainActivity extends AppCompatActivity {
    Button btnCreateTable;
    Button tbnInputData;
    Button btnRetrieveData;
    MyDBHelper myDBHelper;
    SQLiteDatabase sqlLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("SQLite Practices");
        myDBHelper = new MyDBHelper(this);

        btnCreateTable = (Button) findViewById(R.id.btnCreateTable);
        btnCreateTable.setOnClickListener(v -> {
            String sql = "CREATE TABLE userTBL( " +
                    "id CHAR(20) PRIMARY KEY," +
                    "name CHAR(20)," +
                    "email CHAR(50)," +
                    "birthyear INTEGER" +
            " ); ";
            sqlLite = myDBHelper.getWritableDatabase();
            sqlLite.execSQL(sql);
            sqlLite.close();
        });

        tbnInputData = (Button) findViewById(R.id.btnInputData);
        tbnInputData.setOnClickListener(v -> {
            final Intent intent = new Intent(getApplicationContext(), inputDataActivity.class);
            startActivity(intent);
        });

        btnRetrieveData = (Button) findViewById(R.id.btnRetrieveData);
        btnRetrieveData.setOnClickListener(v -> {
            final Intent intent = new Intent(getApplicationContext(), RetrieveDataActivity.class);
            startActivity(intent);
        });
    }
}