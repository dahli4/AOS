package com.example.android10;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int selectYear, selectMonth, selectDay, selectHours, selectMinite ;
    Chronometer cronometer;
    Button btnStart, btnEnd ;
    TextView tvFinalDate ;
    TimePicker tpTime ;
    CalendarView dpDate ;
    RadioGroup rgSelectCase;
    RadioButton rbDate, rbTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tpTime=(TimePicker)  findViewById( R.id.tpTime ) ;
        dpDate = (CalendarView)  findViewById( R.id.dpDate ) ;
        dpDate.setVisibility( View.INVISIBLE);
        tpTime.setVisibility( View.INVISIBLE);
        cronometer = (Chronometer)  findViewById( R.id.cronometer ) ;
        rbDate = (RadioButton) findViewById( R.id.rbDate ) ;
        rbDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "날짜선택...", Toast.LENGTH_SHORT).show();
                tpTime.setVisibility( View.GONE );
                dpDate.setVisibility( View.VISIBLE  );
            }
        });
        rbTime = (RadioButton) findViewById( R.id.rbTime ) ;
        rbTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tpTime.setVisibility( View.VISIBLE );
                dpDate.setVisibility( View.GONE);
            }
        });
        btnStart = (Button)  findViewById( R.id.btnStart ) ;
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rgSelectCase.setVisibility( View.VISIBLE );
                cronometer.setBase(SystemClock.elapsedRealtime());
                cronometer.setTextColor( Color.RED );
                cronometer.start() ;
            }
        });
        btnEnd = (Button)  findViewById( R.id.btnEnd ) ;
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df = new DecimalFormat("00");
                String finalResult =  selectYear+" 년 "+
                                                   df.format(selectMonth)+ " 월 " +
                                                   df.format(selectDay )+" 일 " +
                                                   df.format(selectHours) +" 시 "+
                                                   df.format(selectMinite)+" 분 예약완료";
                tvFinalDate.setText( finalResult );
                cronometer.stop();;
                cronometer.setTextColor( Color.BLACK );
            }
        });

        tvFinalDate=(TextView)  findViewById( R.id.tvFinalDate ) ;
        tpTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                selectHours=hourOfDay;
                selectMinite=minute;
            }
        });
        dpDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month + 1;
                selectDay = dayOfMonth;
            }
        });
        rgSelectCase=(RadioGroup)  findViewById( R.id.rgSelectCase ) ;

    }
}