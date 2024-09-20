package com.example.volumecalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculationActivity3 extends AppCompatActivity {
    TextView title, result;
    EditText editValue1, editValue2, editValue3;
    Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculation3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        editValue1 = findViewById(R.id.editValue1);
        editValue2 = findViewById(R.id.editValue2);
        editValue3 = findViewById(R.id.editValue3);
        btnCalculate = findViewById(R.id.btnCalculate);

        Intent i = getIntent();
        String shapeName = i.getStringExtra("shapeName");
        String shapeImgStr = i.getStringExtra("shapeImg");
        int shapeImg = 0; // Default value
        if (shapeImgStr != null) {
            shapeImg = Integer.parseInt(shapeImgStr);
        } else {

        }

        Prism prism = new Prism(shapeImg, shapeName);
        btnCalculate.setOnClickListener(v -> {
            String inputValue1 = editValue1.getText().toString();
            String inputValue2 = editValue2.getText().toString();
            String inputValue3 = editValue2.getText().toString();

            if (inputValue1.isEmpty() || inputValue2.isEmpty() || inputValue3.isEmpty()) {
                editValue1.setError("Please enter a value");
                editValue2.setError("Please enter a value");
                editValue3.setError("Please enter a value");
                return;
            }

            double input1, input2, input3;
            try {
                input1 = Double.parseDouble(inputValue1);
                input2 = Double.parseDouble(inputValue2);
                input3 = Double.parseDouble(inputValue2);

            } catch (NumberFormatException e) {
                editValue1.setError("Invalid number format");
                editValue2.setError("Invalid number format");                
                editValue3.setError("Invalid number format");


                return;
            }

            double resultValue = prism.CalculateVolume(input1, input2, input3);
            String formattedVolume = String.format("%.2f m³", resultValue);
            result.setText("Volume of " + shapeName + ": " + formattedVolume);

        });
    }
}