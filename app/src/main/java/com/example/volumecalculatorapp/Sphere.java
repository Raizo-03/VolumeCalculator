package com.example.volumecalculatorapp;

public class Sphere extends Shape {
    private String shapeName = "Sphere";
    private int shapeImage = R.drawable.sphere;

    public Sphere(int shapeImg, String shapeName) {
        super(shapeImg, shapeName);
        this.shapeImage = shapeImg;
        this.shapeName = shapeName;
    }

    public double CalculateVolume(double r){
        return 1.333 * Math.PI * r * r * r;
    }

}
