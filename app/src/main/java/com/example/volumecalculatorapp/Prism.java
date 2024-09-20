package com.example.volumecalculatorapp;

public class Prism extends Shape{
    private String shapeName = "Prism";
    private int shapeImg = R.drawable.prism;


    public Prism(int shapeImg, String shapeName) {
        super(shapeImg, shapeName);
    }

    public double CalculateVolume(double l, double w, double h){
        return l * w * h;
    }


}
