package com.seawayproject.injplastapp.main.calculators;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.seawayproject.injplastapp.R;

/**
 * @author : Alexandr Onuferco
 * @created : 21/11/2021, Sunday
 * This project was created for educational purposes
 * all the referenced works are properties of respected copyright owners
 **/
public class MaterialRequired extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_required_activity);

        Button calculate = findViewById(R.id.calculateButton);
        Button reset = findViewById(R.id.resetButton);

        TextView output = findViewById(R.id.outputResult);
        TextView partText = findViewById(R.id.partwg);
        TextView outputText = findViewById(R.id.output);

        EditText quantityText = findViewById(R.id.quantEdit);
        EditText partwgText = findViewById(R.id.partwgEdit);
        EditText cavityText = findViewById(R.id.cavityEdit);
        EditText runnerwgText = findViewById(R.id.runnerEdit);

        ToggleButton unit = findViewById(R.id.unitToggle);

        unit.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                partText.setText("Part weight (grams):");
                outputText.setText("Output (kg):");
            } else {
                partText.setText("Part weight (ounces):");
                outputText.setText("Output (lbs):");
            }
        });

        calculate.setOnClickListener(view -> {
            String quantity = quantityText.getText().toString();
            String part = partwgText.getText().toString();
            String cavity = cavityText.getText().toString();
            String runner = runnerwgText.getText().toString();
            if (part == null || cavity == null || part.equals("0") || cavity.equals("0") || part.trim().equals("") || cavity.trim().equals("")
                    || quantity == null || quantity.equals("0") || quantity.trim().equals("") || runner == null || runner.equals("0") || runner.trim().equals("")) {
                Toast.makeText(this, "Please enter a valid value", Toast.LENGTH_SHORT).show();
            }
            else {
                double partsCount = ((Double.parseDouble(quantity) * Double.parseDouble(runner)) / Double.parseDouble(cavity)) + (Double.parseDouble(part) * Double.parseDouble(quantity));
                output.setText(unit.isChecked() ? String.valueOf(partsCount / 1000) : String.valueOf(partsCount / 16));
            }
        });

        reset.setOnClickListener(view -> {
            quantityText.setText("");
            partwgText.setText("");
            cavityText.setText("");
            runnerwgText.setText("");
            output.setText("");
        });
    }
}
