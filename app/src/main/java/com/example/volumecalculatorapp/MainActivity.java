package com.example.volumecalculatorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //AdapterView : gridview
    GridView gridview;

    //Data Source : Array List
    ArrayList<Shape> shapes;


    //Adapter : MyCustomAdapter
    MyCustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gridview = findViewById(R.id.gridView);
        shapes = new ArrayList<>();

        Shape cube = new Shape(R.drawable.cube, "Cube");
        Shape sphere = new Shape(R.drawable.sphere, "Sphere");
        Shape cylinder = new Shape(R.drawable.cylinder, "Cylinder");
        Shape prism = new Shape(R.drawable.prism, "Prism");

        shapes.add(cube);
        shapes.add(sphere);
        shapes.add(cylinder);
        shapes.add(prism);

        customAdapter = new MyCustomAdapter(shapes, getApplicationContext());
        gridview.setAdapter(customAdapter);
        //setting the number of columns
        gridview.setNumColumns(2);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Shape selectedShape = shapes.get(position);
                Intent i = null;

                if(selectedShape.getShapeName().equals("Cube") || selectedShape.getShapeName().equals("Sphere")){
                    i = new Intent(getApplicationContext(), CalculationActivity.class);
                }else if(selectedShape.getShapeName().equals("Cylinder")){
                    i = new Intent(getApplicationContext(), CalculationActivity2.class);
                }else if(selectedShape.getShapeName().equals("Prism")){
                    i = new Intent(getApplicationContext(), CalculationActivity3.class);
                }

                if(i != null){
                 i.putExtra("shapeName", selectedShape.getShapeName());
                 i.putExtra("ShapeImg" , selectedShape.getShapeImg());
                 startActivity(i);

                }



            }
        });




    }
}