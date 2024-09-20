package com.example.volumecalculatorapp;

public class Cube extends Shape{
    private String shapeName = "Cube";
    private int shapeImg = R.drawable.cube;


    public Cube(int shapeImg, String shapeName){
        super(shapeImg, shapeName);

        this.shapeImg = shapeImg;
        this.shapeName = shapeName;
    }


    public double CalculateVolume(double s){
        return s * s *s;
    }

}
