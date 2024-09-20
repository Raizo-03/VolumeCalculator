package com.example.volumecalculatorapp;

public class Cylinder extends Shape{
    private String shapeName = "Cylinder";
    private int shapeImg = R.drawable.cylinder;


    public Cylinder(int shapeImg, String shapeName) {
        super(shapeImg, shapeName);
        this.shapeImg = shapeImg;
        this.shapeName = shapeName;
    }

    public double CalculateVolume(double r, double h){
        return Math.PI * r * r * h;
    }

}
