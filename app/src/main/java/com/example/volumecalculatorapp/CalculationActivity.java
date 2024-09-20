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

public class CalculationActivity extends AppCompatActivity {
    TextView title, result;
    EditText editValue;
    Button   btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        title = findViewById(R.id.title);
        result = findViewById(R.id.result);
        editValue = findViewById(R.id.editValue);
        btnCalculate = findViewById(R.id.btnCalculate);



        Intent i =  getIntent();
        String shapeName = i.getStringExtra("shapeName");
        String shapeImgStr = i.getStringExtra("shapeImg");
        int shapeImg = 0; // Default value
        if (shapeImgStr != null) {
            shapeImg = Integer.parseInt(shapeImgStr);
        } else {

        }

        Cube cube = new Cube(shapeImg, shapeName);
        Sphere sphere = new Sphere(shapeImg, shapeName);


        if (shapeName.equals("Cube")) {
            title.setText("Cube Volume");
            editValue.setHint("Enter length of side in meters");


        } else if (shapeName.equals("Sphere")) {
            title.setText("Sphere Volume");
            editValue.setHint("Enter radius in meters");
        }

        btnCalculate.setOnClickListener(v -> {
            String inputValue = editValue.getText().toString();
            if (inputValue.isEmpty()) {
                editValue.setError("Please enter a value");
                return;
            }

            double input;
            try {
                input = Double.parseDouble(inputValue);
            } catch (NumberFormatException e) {
                editValue.setError("Invalid number format");
                return;
            }

            double resultValue;
            if (shapeName.equals("Cube")) {
                resultValue = cube.CalculateVolume(input);
            } else if (shapeName.equals("Sphere")) {
                resultValue = sphere.CalculateVolume(input);
            } else {
                // Handle unexpected shape name
                result.setText("Unknown shape");
                return;
            }

            String formattedVolume = String.format("%.2f m³", resultValue);
            result.setText("Volume of " + shapeName + ": " + formattedVolume);
        });



    }
}