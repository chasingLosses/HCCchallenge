package com.house.construction.company;

public class Door extends Hole{

    public Door(double width, double length, String color, int quality, String type) {
        super(width, length, color, quality, type);
    }

    public Door(Hole hole){
        super(hole.getWidth(), hole.getLength(),hole.getColor(),hole.getQuality(),hole.getType());
    }

    public Door(){
        super();
    }

    @Override
    public String toString() {
        if(super.getQuality() != -2)
            return "\t"+ this.getClass().getSimpleName() + super.toString();
        return "";
    }

}
