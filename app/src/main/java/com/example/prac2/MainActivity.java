package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText dateTxt, timeTxt;

    ImageButton dateBut, timeBut;

    Button applyBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTxt = findViewById(R.id.date_txt);
        timeTxt = findViewById(R.id.time_txt);
        dateBut = findViewById(R.id.date_but);
        timeBut = findViewById(R.id.time_but);
        applyBut = findViewById(R.id.apply_but);

        dateBut.setOnClickListener(x -> {
            int year = 2021;
            int month = 11;
            int date = 14;

            DatePickerDialog.OnDateSetListener datePick = (datePicker, i, i1, i2) ->
                    dateTxt.setText(""+i+"-"+(i1+1)+"-"+i2);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    datePick,year, month, date);
            datePickerDialog.show();
        });

        timeBut.setOnClickListener(x -> {

            int hour = 13;
            int minute = 24;
            boolean is24Hours = true;

            TimePickerDialog.OnTimeSetListener timePick = (timePicker, i, i1) ->
                    timeTxt.setText(i + ":" + i1);

            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                    timePick, hour, minute, is24Hours);
            timePickerDialog.show();
        });

        applyBut.setOnClickListener(x ->{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Подтверждение записи").setIcon(R.drawable.ic_date)
                    .setMessage("Вы подтверждаете запись ?")
                    .setPositiveButton("Подтвердить", (dialogInterface, i) -> {
                        dialogInterface.cancel();
                        Toast.makeText(MainActivity.this, "Ваша запись подтверждена",
                                Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Отменить", (dialogInterface, i) ->
                            dialogInterface.cancel())
                    .create();
            builder.show();
        });
    }
}