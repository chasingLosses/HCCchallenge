package com.house.construction.company;

public class Window extends Hole{

    public Window(double width, double length, String color, int quality, String type) {
        super(width, length, color, quality, type);
    }

    public Window(Hole hole){
        super(hole.getWidth(), hole.getLength(),hole.getColor(),hole.getQuality(),hole.getType());
    }

    public Window(){
        super();
    }

    @Override
    public String toString() {
        if(super.getQuality() != -2)
            return "\t"+ this.getClass().getSimpleName() + super.toString();
        return "";
    }
}
