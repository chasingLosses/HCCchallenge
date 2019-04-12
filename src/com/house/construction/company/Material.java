package com.house.construction.company;

public class Material {
    private String name;
    private double price;
    private boolean forBase;
    private boolean forDoor;
    private boolean forWindow;


    public Material(String material, double price,boolean forBase, boolean forDoor, boolean forWindow) {
        this.name = material;
        this.price = price;
        this.forBase = forBase;
        this.forDoor = forDoor;
        this.forWindow = forWindow;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isForBase() {
        return forBase;
    }

    public boolean isForDoor() {
        return forDoor;
    }

    public boolean isForWindow() {
        return forWindow;
    }

}
