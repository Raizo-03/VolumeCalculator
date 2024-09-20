package com.example.volumecalculatorapp;
// This class is acting as "Model Class"
// it represents the data structure of individual items
// that your adapter is going to display


public class Shape {
    private int shapeImg;
    private String shapeName;

    public Shape(int shapeImg, String shapeName) {
        this.shapeImg = shapeImg;
        this.shapeName = shapeName;
    }
    public double CalculateVolume(double value) { return value;}

    public int getShapeImg() {
        return shapeImg;
    }

    public void setShapeImg(int shapeImg) {
        this.shapeImg = shapeImg;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

}
