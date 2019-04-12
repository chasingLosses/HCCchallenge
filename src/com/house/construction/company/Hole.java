package com.house.construction.company;

public class Hole {
    private double width;
    private double length;
    private String color;
    private int quality;
    private String type;

    public Hole(double width, double length, String color, int quality, String type) {
        this.width = width;
        this.length = length;
        this.color = color;
        this.quality = quality;
        this.type = type;
    }

    public Hole(){
        this.width = 0;
        this.length = 0;
        this.color = "";
        this.quality = -2;
        this.type = "";
    }

    public double getWidth() {
        return width;
    }


    public double getLength() {
        return length;
    }


    public String getColor() {
        return color;
    }


    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getType() {
        return type;
    }

    public double getArea(){
        return Math.ceil(length * width);
    }

    @Override
    public String toString() {
        return " is colored " + this.color + ", " + this.getArea() +" m2 of " + this.type;
    }
}
