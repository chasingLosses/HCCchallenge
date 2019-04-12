package com.house.construction.company;

public class Roof {
    private double width;
    private double length;
    private int quality;
    private String type;

    public Roof(double width, double length, int quality, String type) {
        this.width = width;
        this.length = length;
        this.quality = quality;
        this.type = type;
    }

    public Roof(){
        this.width = 0;
        this.length = 0;
        this.quality = -2;
        this.type = "";
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public int getQuality() {
        return quality;
    }

    public String getType() {
        return type;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getArea(){
        return Math.ceil(width * length);
    }

    @Override
    public String toString() {
        if(quality != -2)
            return this.getClass().getSimpleName() +" " + this.getArea() + " m2 of "+ this.getType();
        return "";
    }
}
