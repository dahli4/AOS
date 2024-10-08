package com.example.android15;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];

        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;
        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};

        final String imgName[] = {"독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서"};
        for (int i = 0; i < 9; i++) {
            final int index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(v -> {
                voteCount[index]++;
                Toast.makeText(getApplicationContext(),
                        imgName[index] + ": 총 " + voteCount[index] + " 표",
                        Toast.LENGTH_SHORT).show();
            });
        }

        btnResult = (Button) findViewById(R.id.btnResult);

        btnResult.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("VoteCount", voteCount);
            intent.putExtra("ImageName", imgName);
            startActivity(intent);
            startActivityForResult(intent, 0);

        });
    }
}