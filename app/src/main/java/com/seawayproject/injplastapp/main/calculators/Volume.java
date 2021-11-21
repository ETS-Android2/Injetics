package com.seawayproject.injplastapp.main.calculators;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.seawayproject.injplastapp.R;

import java.util.Arrays;

/**
 * @author : Alexandr Onuferco
 * @created : 21/11/2021, Sunday
 * This project was created for educational purposes
 * all the referenced works are properties of respected copyright owners
 **/
public class Volume extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_activity);

        Button calculate = findViewById(R.id.calculateButton);
        Button reset = findViewById(R.id.resetButton);

        TextView minuteText = findViewById(R.id.minuteResult);
        TextView hourlyText = findViewById(R.id.hourlyResult);
        TextView dailyText = findViewById(R.id.dailyResult);
        TextView weeklyText = findViewById(R.id.weeklyResult);
        TextView monthlyText = findViewById(R.id.monthlyResult);
        TextView yearlyText = findViewById(R.id.yearlyResult);

        EditText cycleText = findViewById(R.id.cycleEdit);
        EditText efficiencyText = findViewById(R.id.efficiencyEdit);
        EditText cavityText = findViewById(R.id.cavityEdit);
        EditText prodText = findViewById(R.id.timeEdit);


        calculate.setOnClickListener(view -> {
            String cycle = cycleText.getText().toString();
            String efficiency = efficiencyText.getText().toString();
            String cavity = cavityText.getText().toString();
            String production = prodText.getText().toString();
            if (cycle == null || cavity == null || cycle.equals("0") || cavity.equals("0") || cycle.trim().equals("") || cavity.trim().equals("")
                    || efficiency == null || efficiency.equals("0") || efficiency.trim().equals("") || production == null || production.equals("0") || production.trim().equals("")) {
                Toast.makeText(this, "Please enter a valid value", Toast.LENGTH_SHORT).show();
            } else {
                double efficiencyD = Double.parseDouble(efficiency) / 100;
                double cavityD = Double.parseDouble(cavity);
                double cyclePerMin = (60.0 / Double.parseDouble(cycle)) * efficiencyD;
                double cyclePerHour = cyclePerMin * 60;
                double cyclePerDay = cyclePerHour * Double.parseDouble(production);
                double cyclePerWeek = cyclePerDay * 7;
                double cyclePerYear = cyclePerWeek * 52;
                double cyclePerMonth = cyclePerYear / 12;

                double partsPerMin = Math.floor(Math.floor(cyclePerMin) * cavityD);
                double partsPerHour = Math.floor(cyclePerHour * cavityD);
                double partsPerDay = Math.floor(cyclePerDay * cavityD);
                double partsPerWeek = Math.floor(cyclePerWeek * cavityD);
                double partsPerMonth = Math.floor(cyclePerMonth * cavityD);
                double partsPerYear = Math.floor(cyclePerYear * cavityD);

                minuteText.setText(String.valueOf(partsPerMin));
                hourlyText.setText(String.valueOf(partsPerHour));
                dailyText.setText(String.valueOf(partsPerDay));
                weeklyText.setText(String.valueOf(partsPerWeek));
                monthlyText.setText(String.valueOf(partsPerMonth));
                yearlyText.setText(String.valueOf(partsPerYear));
            }
        });

        reset.setOnClickListener(view -> {
            cycleText.setText("");
            efficiencyText.setText("");
            cavityText.setText("");
            prodText.setText("");

            minuteText.setText("");
            hourlyText.setText("");
            dailyText.setText("");
            weeklyText.setText("");
            monthlyText.setText("");
            yearlyText.setText("");
        });
    }
}
