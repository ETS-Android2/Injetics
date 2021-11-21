package com.seawayproject.injplastapp.main.calculators;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.seawayproject.injplastapp.R;

/**
 * @author : Alexandr Onuferco
 * @created : 21/11/2021, Sunday
 * This project was created for educational purposes
 * all the referenced works are properties of respected copyright owners
 **/
public class ProductionTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.production_time_activity);

        Button calculate = findViewById(R.id.calculateButton);
        Button reset = findViewById(R.id.resetButton);

        TextView output = findViewById(R.id.outputResult);

        EditText quantityText = findViewById(R.id.quantEdit);
        EditText cycleText = findViewById(R.id.cycleEdit);
        EditText cavityText = findViewById(R.id.cavityEdit);

        calculate.setOnClickListener(view -> {
            String quantity = quantityText.getText().toString();
            String cycle = cycleText.getText().toString();
            String cavity = cavityText.getText().toString();
            if (cycle == null || cavity == null || cycle.equals("0") || cavity.equals("0") || cycle.trim().equals("") || cavity.trim().equals("")
                || quantity == null || quantity.equals("0") || quantity.trim().equals("")) {
                Toast.makeText(this, "Please enter a valid value", Toast.LENGTH_SHORT).show();
            }
            else {
                double partsCount = Double.parseDouble(quantity) / ((3600 * Integer.parseInt(cavity)) / Double.parseDouble(cycle));
                output.setText(String.format("%.1f", partsCount));
            }
        });

        reset.setOnClickListener(view -> {
            quantityText.setText("");
            cycleText.setText("");
            cavityText.setText("");
            output.setText("");
        });
    }
}
