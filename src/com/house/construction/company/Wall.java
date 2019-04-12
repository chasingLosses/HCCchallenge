package com.house.construction.company;

import java.util.List;

public class Wall extends Roof {

    private Door door1;
    private Door door2;
    private Door door3;
    private Door door4;
    private Door door5;

    private Window window1;
    private Window window2;
    private Window window3;
    private Window window4;
    private Window window5;

    public Wall(double width, double length, int quality, String type, Door door1, Door door2, Door door3, Door door4, Door door5, Window window1, Window window2, Window window3, Window window4, Window window5) {
        super(width, length, quality, type);
        this.door1 = new Door(door1.getWidth(),door1.getLength(),door1.getColor(),door1.getQuality(),door1.getType());
        this.door2 = new Door(door2.getWidth(),door2.getLength(),door2.getColor(),door2.getQuality(),door2.getType());
        this.door3 = new Door(door3.getWidth(),door3.getLength(),door3.getColor(),door3.getQuality(),door3.getType());
        this.door4 = new Door(door4.getWidth(),door4.getLength(),door4.getColor(),door4.getQuality(),door4.getType());
        this.door5 = new Door(door5.getWidth(),door5.getLength(),door5.getColor(),door5.getQuality(),door5.getType());
        this.window1 = new Window(window1.getWidth(),window1.getLength(),window1.getColor(),window1.getQuality(),window1.getType());
        this.window2 = new Window(window2.getWidth(),window2.getLength(),window2.getColor(),window2.getQuality(),window2.getType());
        this.window3 = new Window(window3.getWidth(),window3.getLength(),window3.getColor(),window3.getQuality(),window3.getType());
        this.window4 = new Window(window4.getWidth(),window4.getLength(),window4.getColor(),window4.getQuality(),window4.getType());
        this.window5 = new Window(window5.getWidth(),window5.getLength(),window5.getColor(),window5.getQuality(),window5.getType());
    }

    public Wall(double width, double length, int quality, String type) {
        super(width, length, quality, type);
        this.door1 = new Door();
        this.door2 = new Door();
        this.door3 = new Door();
        this.door4 = new Door();
        this.door5 = new Door();
        this.window1 = new Window();
        this.window2 = new Window();
        this.window3 = new Window();
        this.window4 = new Window();
        this.window5 = new Window();
    }

    public Wall(Roof roof){
        super(roof.getWidth(),roof.getLength(),roof.getQuality(),roof.getType());
        this.door1 = new Door();
        this.door2 = new Door();
        this.door3 = new Door();
        this.door4 = new Door();
        this.door5 = new Door();
        this.window1 = new Window();
        this.window2 = new Window();
        this.window3 = new Window();
        this.window4 = new Window();
        this.window5 = new Window();
    }

    public Wall(){
        super();
        this.door1 = new Door();
        this.door2 = new Door();
        this.door3 = new Door();
        this.door4 = new Door();
        this.door5 = new Door();
        this.window1 = new Window();
        this.window2 = new Window();
        this.window3 = new Window();
        this.window4 = new Window();
        this.window5 = new Window();
    }

    public Door getDoor1() {
        return door1;
    }

    public Door getDoor2() {
        return door2;
    }

    public Door getDoor3() {
        return door3;
    }

    public Door getDoor4() {
        return door4;
    }

    public Door getDoor5() {
        return door5;
    }

    public Window getWindow1() {
        return window1;
    }

    public Window getWindow2() {
        return window2;
    }

    public Window getWindow3() {
        return window3;
    }

    public Window getWindow4() {
        return window4;
    }

    public Window getWindow5() {
        return window5;
    }

    public void setDoor1(Door door1) {
        this.door1 = door1;
    }

    public void setDoor2(Door door2) {
        this.door2 = door2;
    }

    public void setDoor3(Door door3) {
        this.door3 = door3;
    }

    public void setDoor4(Door door4) {
        this.door4 = door4;
    }

    public void setDoor5(Door door5) {
        this.door5 = door5;
    }

    public void setWindow1(Window window1) {
        this.window1 = window1;
    }

    public void setWindow2(Window window2) {
        this.window2 = window2;
    }

    public void setWindow3(Window window3) {
        this.window3 = window3;
    }

    public void setWindow4(Window window4) {
        this.window4 = window4;
    }

    public void setWindow5(Window window5) {
        this.window5 = window5;
    }

    @Override
    public String toString() {
        return super.toString() + door1.toString() + door2.toString() + door3.toString() + door4.toString() + door5.toString()
                + window1.toString() + window2.toString() + window3.toString() + window4.toString() + window5.toString();
    }
}
