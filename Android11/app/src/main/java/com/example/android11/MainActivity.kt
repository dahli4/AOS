package com.example.android11

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.Chronometer
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    var selectYear: Int = 0
    var selectMonth: Int = 0
    var selectDay: Int = 0
    var selectHours: Int = 0
    var selectMinute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tpTime = findViewById<TimePicker>(R.id.tpTime)
        val dpDate = findViewById<CalendarView>(R.id.dpDate)
        val cronometer = findViewById<Chronometer>(R.id.cronometer)
        val rbDate = findViewById<RadioButton>(R.id.rbDate)
        val rbTime = findViewById<RadioButton>(R.id.rbTime)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnEnd = findViewById<Button>(R.id.btnEnd)
        val tvFinalDate = findViewById<TextView>(R.id.tvFinalDate)
        val rgSelectCase = findViewById<RadioGroup>(R.id.rgSelectCase)

        dpDate.visibility = View.INVISIBLE
        tpTime.visibility = View.INVISIBLE

        rbDate.setOnClickListener {
            tpTime.visibility = View.GONE
            dpDate.visibility = View.VISIBLE
        }

        rbTime.setOnClickListener {
            tpTime.visibility = View.VISIBLE
            dpDate.visibility = View.GONE
        }

        btnStart.setOnClickListener {
            rgSelectCase.visibility = View.VISIBLE
            cronometer.base = SystemClock.elapsedRealtime()
            cronometer.setTextColor(Color.RED)
            cronometer.start()
        }

        tpTime.setOnTimeChangedListener { view, hourOfDay, minute ->
            selectHours = hourOfDay
            selectMinute = minute
        }

        dpDate.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
        }

        btnEnd.setOnClickListener {
            val df: DecimalFormat = DecimalFormat("00")
            val finalResult = ((((selectYear.toString() + " 년 " +
                    df.format(selectMonth)).toString() + " 월 " +
                    df.format(selectDay)).toString() + " 일 " +
                    df.format(selectHours)).toString() + " 시 " +
                    df.format(selectMinute)).toString() + " 분 예약완료"
            tvFinalDate.text = finalResult
            cronometer.stop()
            cronometer.setTextColor(Color.BLACK)
        }
    }
}