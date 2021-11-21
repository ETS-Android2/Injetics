package com.seawayproject.injplastapp.main.calculators;

import android.os.Bundle;
import android.view.View;
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
public class ProductionRate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.production_rate_activity);

        Button calculate = findViewById(R.id.calculateButton);
        Button reset = findViewById(R.id.resetButton);

        TextView output = findViewById(R.id.outputResult);

        EditText cycleText = findViewById(R.id.cycleEdit);
        EditText cavityText = findViewById(R.id.cavityEdit);


        calculate.setOnClickListener(view -> {
            String cycle = cycleText.getText().toString();
            String cavity = cavityText.getText().toString();
            if (cycle == null || cavity == null || cycle.equals("0") || cavity.equals("0") || cycle.trim().equals("") || cavity.trim().equals("")) {
                Toast.makeText(this, "Please enter a valid value", Toast.LENGTH_SHORT).show();
            }
            else {
                int partsCount = (3600 * Integer.parseInt(cavity)) / Integer.parseInt(cycle);
                output.setText(Integer.toString(partsCount));
            }
        });

        reset.setOnClickListener(view -> {
            cycleText.setText("");
            cavityText.setText("");
            output.setText("");
        });
    }
}
