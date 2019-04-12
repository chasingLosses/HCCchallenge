package com.house.construction.company;

import java.awt.*;

public class House {
    private Wall wall1;
    private Wall wall2;
    private Wall wall3;
    private Wall wall4;

    private Roof roof;

    public House(Wall wall1, Wall wall2, Wall wall3, Wall wall4, Roof roof) {
        this.wall1 = new Wall(wall1.getWidth(),wall1.getLength(), wall1.getQuality(),wall1.getType(),wall1.getDoor1(),wall1.getDoor2(),wall1.getDoor3(),wall1.getDoor4(),wall1.getDoor5(),wall1.getWindow1(),wall1.getWindow2(),wall1.getWindow3(),wall1.getWindow4(),wall1.getWindow5());
        this.wall2 = new Wall(wall2.getWidth(),wall2.getLength(), wall2.getQuality(),wall2.getType(),wall2.getDoor1(),wall2.getDoor2(),wall2.getDoor3(),wall2.getDoor4(),wall2.getDoor5(),wall2.getWindow1(),wall2.getWindow2(),wall2.getWindow3(),wall2.getWindow4(),wall2.getWindow5());
        this.wall3 = new Wall(wall3.getWidth(),wall3.getLength(), wall3.getQuality(),wall3.getType(),wall3.getDoor1(),wall3.getDoor2(),wall3.getDoor3(),wall3.getDoor4(),wall3.getDoor5(),wall3.getWindow1(),wall3.getWindow2(),wall3.getWindow3(),wall3.getWindow4(),wall3.getWindow5());
        this.wall4 = new Wall(wall4.getWidth(),wall4.getLength(), wall4.getQuality(),wall4.getType(),wall4.getDoor1(),wall4.getDoor2(),wall4.getDoor3(),wall4.getDoor4(),wall4.getDoor5(),wall4.getWindow1(),wall4.getWindow2(),wall4.getWindow3(),wall4.getWindow4(),wall4.getWindow5());
        this.roof = new Roof(roof.getWidth(), roof.getLength(), roof.getQuality(), roof.getType());
    }

    public House(){
        this.wall1 = new Wall();
        this.wall2 = new Wall();
        this.wall3 = new Wall();
        this.wall4 = new Wall();
        this.roof = new Roof();
    }

    public Wall getWall1() {
        return wall1;
    }

    public Wall getWall2() {
        return wall2;
    }

    public Wall getWall3() {
        return wall3;
    }

    public Wall getWall4() {
        return wall4;
    }

    public Roof getRoof() {
        return roof;
    }

    public static boolean validQuality(int value){
        if(value < -1 || value > 1)
            return false;
        return true;
    }
    public static boolean validDimension(double value){
        if(value < 0.d)
            return false;
        return true;
    }
    private enum simpleColor{
        RED,
        BLUE,
        GREEN,
        YELLOW,
        ORANGE,
        PURPLE,
        BLACK,
        WHITE,
        GRAY,
        SILVER,
        GOLD,
        PINK,
        OLIVE
    }
    public static boolean validColor(String value){
        for(simpleColor color  : simpleColor.values()){
            if(color.name().equals(value.toUpperCase()))
                return true;
        }
        return false;
    }
    public static House setQualityForAllElements(House h, int quality){
        House hcopy = new House(h.wall1,h.wall2,h.wall3,h.wall4,h.roof);
        hcopy.getRoof().setQuality(quality);
        hcopy.getWall1().setQuality(quality);
        hcopy.getWall2().setQuality(quality);
        hcopy.getWall3().setQuality(quality);
        hcopy.getWall4().setQuality(quality);
        setQualityForWall(hcopy.getWall1(),quality);
        setQualityForWall(hcopy.getWall2(),quality);
        setQualityForWall(hcopy.getWall3(),quality);
        setQualityForWall(hcopy.getWall4(),quality);
        return hcopy;
    }
    public static void setQualityForWall(Wall wall, int quality){
        if (wall.getDoor1().getQuality() != -2)
            wall.getDoor1().setQuality(quality);
        if (wall.getDoor2().getQuality() != -2)
            wall.getDoor2().setQuality(quality);
        if (wall.getDoor3().getQuality() != -2)
            wall.getDoor3().setQuality(quality);
        if (wall.getDoor4().getQuality() != -2)
            wall.getDoor4().setQuality(quality);
        if (wall.getDoor5().getQuality() != -2)
            wall.getDoor5().setQuality(quality);
        if (wall.getWindow1().getQuality() != -2)
            wall.getWindow1().setQuality(quality);
        if (wall.getWindow2().getQuality() != -2)
            wall.getWindow2().setQuality(quality);
        if (wall.getWindow3().getQuality() != -2)
            wall.getWindow3().setQuality(quality);
        if (wall.getWindow4().getQuality() != -2)
            wall.getWindow4().setQuality(quality);
        if (wall.getWindow5().getQuality() != -2)
            wall.getWindow5().setQuality(quality);
    }
    @Override
    public String toString() {
        return "House: "+ roof.toString() + wall1.toString() + wall2.toString() + wall3.toString() + wall4.toString();
    }
}
