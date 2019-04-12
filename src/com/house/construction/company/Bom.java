package com.house.construction.company;

import java.util.ArrayList;
import java.util.List;

public class Bom extends House{
    static List<Material> materials = new ArrayList<>();
    private boolean pay;
    private int years;

    public Bom(House house, boolean pay, int years){
        super(house.getWall1(),house.getWall2(),house.getWall3(),house.getWall4(),house.getRoof());
        this.pay = pay;
        this.years = years;
    }

    public Bom() {
        super();
        this.pay = false;
        this.years = 0;
    }

    public String checkHouseStability(){
        if(super.getWall1().getLength() == 0 || super.getWall1().getWidth() == 0 ||super.getWall2().getLength() == 0 || super.getWall2().getWidth() == 0|| super.getWall3().getLength() == 0 || super.getWall3().getWidth() == 0|| super.getWall4().getLength() == 0 || super.getWall4().getWidth() == 0)
            return "One of the walls is not defined yet.";
        if(super.getWall1().getLength() != super.getWall2().getLength() || super.getWall1().getLength() != super.getWall3().getLength() || super.getWall1().getLength() != super.getWall4().getLength())
            return "All walls should have same length/height.";
        if(super.getWall1().getArea() < wallHolesArea(super.getWall1()))
            return "The area of windows and doors is greater then the wall area in first wall.";

        if(super.getWall2().getArea() < wallHolesArea(super.getWall2()))
            return "The area of windows and doors is greater then the wall area in second wall.";

        if(super.getWall3().getArea() < wallHolesArea(super.getWall3()))
            return "The area of windows and doors is greater then the wall area in third wall.";

        if(super.getWall4().getArea() < wallHolesArea(super.getWall4()))
            return "The area of windows and doors is greater then the wall area in fourth wall.";

        if(!checkTypes(super.getWall1())){
            return "The type of window/door in first wall is incompatible.";
        }
        if(!checkTypes(super.getWall2())){
            return "The type of window/door in second wall is incompatible.";
        }
        if(!checkTypes(super.getWall3())){
            return "The type of window/door in third wall is incompatible.";
        }
        if(!checkTypes(super.getWall4())){
            return "The type of window/door in fourth wall is incompatible.";
        }

        for(Material m : materials) {
            if (m.getName().equals(super.getRoof().getType())) {
                if (!m.isForBase())
                    return "Select a material for roof, that is available";
            }
        }

        if(super.getWall1().getWidth() == super.getWall2().getWidth() && super.getWall3().getWidth() == super.getWall4().getWidth()) {
            if(super.getWall1().getWidth() == getRoof().getWidth() && super.getWall3().getWidth() == super.getRoof().getLength() || super.getWall1().getWidth() == getRoof().getLength() && super.getWall3().getWidth() == super.getRoof().getWidth()){
                return"OK";
            } else
                return "The roof doesn't fit on the base of the house.";
        } else if(super.getWall1().getWidth() == super.getWall3().getWidth() && super.getWall2().getWidth() == super.getWall4().getWidth()){
            if(super.getWall1().getWidth() == getRoof().getWidth() && super.getWall2().getWidth() == super.getRoof().getLength() || super.getWall1().getWidth() == getRoof().getLength() && super.getWall2().getWidth() == super.getRoof().getWidth()){
                return"OK";
            } else
                return "The roof doesn't fit on the base of the house.";
        } else if(super.getWall1().getWidth() == super.getWall4().getWidth() && super.getWall2().getWidth() == super.getWall3().getWidth()) {
            if (super.getWall1().getWidth() == getRoof().getWidth() && super.getWall3().getWidth() == super.getRoof().getLength() || super.getWall1().getWidth() == getRoof().getLength() && super.getWall3().getWidth() == super.getRoof().getWidth()) {
                return "OK";
            } else
                return "The roof doesn't fit on the base of the house.";
        }
        else
            return "One of the widths is different then the others.";

    }
    public boolean checkTypes(Wall wall){
        for(Material m : materials){
            if(m.getName().equals(wall.getDoor1().getType())){
                if(!m.isForDoor())
                    return false;
            }
            if(m.getName().equals(wall.getDoor2().getType())){
                if(!m.isForDoor())
                    return false;
            }
            if(m.getName().equals(wall.getDoor3().getType())){
                if(!m.isForDoor())
                    return false;
            }
            if(m.getName().equals(wall.getDoor4().getType())){
                if(!m.isForDoor())
                    return false;
            }
            if(m.getName().equals(wall.getDoor5().getType())){
                if(!m.isForDoor())
                    return false;
            }
            if(m.getName().equals(wall.getWindow1().getType())){
                if(!m.isForWindow())
                    return false;
            }
            if(m.getName().equals(wall.getWindow2().getType())){
                if(!m.isForWindow())
                    return false;
            }
            if(m.getName().equals(wall.getWindow3().getType())){
                if(!m.isForWindow())
                    return false;
            }
            if(m.getName().equals(wall.getWindow4().getType())){
                if(!m.isForWindow())
                    return false;
            }
            if(m.getName().equals(wall.getWindow5().getType())){
                if(!m.isForWindow())
                    return false;
            }
            if(m.getName().equals(wall.getWindow5().getType())){
                if(!m.isForWindow())
                    return false;
            }
            if(m.getName().equals(wall.getType())){
                if(!m.isForBase())
                    return false;
            }
        }
        return true;
    }


    public double setQuality(int quality){
        if(quality == -1)
            return 0.8d;
        else if(quality == 1)
            return 1.2d;
        return 1d;
    }


    public String showPrice(){
        String s = super.getRoof().toString() + " = " + roundOff2(super.getRoof().getArea()*setQuality(super.getRoof().getQuality())*getMaterialPrice(super.getRoof().getType())) + "€\n";
        double sum =  super.getRoof().getArea()*setQuality(super.getRoof().getQuality())*getMaterialPrice(super.getRoof().getType());
        s += wallOutput(super.getWall1());
        sum += wallCalculateCost(super.getWall1());
        s += wallHoles(super.getWall1());
        sum += holeCalculateCost(super.getWall1());

        s += wallOutput(super.getWall2());
        sum += wallCalculateCost(super.getWall2());
        s += wallHoles(super.getWall2());
        sum += holeCalculateCost(super.getWall2());

        s += wallOutput(super.getWall3());
        sum += wallCalculateCost(super.getWall3());
        s += wallHoles(super.getWall3());
        sum += holeCalculateCost(super.getWall3());

        s += wallOutput(super.getWall4());
        sum += wallCalculateCost(super.getWall4());
        s += wallHoles(super.getWall4());
        sum += holeCalculateCost(super.getWall4());
        return addFinalPrice(s, sum);
    }
    public String addFinalPrice(String s, double sum){
        if(pay) {
            s += "======================================================\n";
            s += "TOTAL: " + roundOff2(sum * 0.9d) + "€ with discount";
            return s;
        }else if(!pay && years > 0){
            s += "======================================================\n";
            s += "Your yearly bill amounts to: " + roundOff2(sum*1.25d/years) +"\n";
            s += "TOTAL: " + roundOff2(sum * 1.25d) +"€";
            return s;
        }
        s += "======================================================\n";
        s += "TOTAL: " + roundOff2(sum) + "€";
        return s;
    }



    public String wallOutput(Wall part){
        return part.getClass().getSimpleName() +" " + (part.getArea() - wallHolesArea(part)) + " m2 of "+ part.getType() + " = " + roundOff2((part.getArea() - wallHolesArea(part))*setQuality(part.getQuality())*getMaterialPrice(part.getType())) + "€\n";
    }
    public double wallCalculateCost(Wall wall){
        return (super.getWall1().getArea() - wallHolesArea(super.getWall1()))*setQuality(super.getWall1().getQuality())*getMaterialPrice(wall.getType());
    }
    public double wallHolesArea(Wall wall){
        double value = wall.getDoor1().getArea();
        value += wall.getDoor1().getArea();
        value += wall.getDoor3().getArea();
        value += wall.getDoor4().getArea();
        value += wall.getDoor5().getArea();
        value += wall.getWindow1().getArea();
        value += wall.getWindow2().getArea();
        value += wall.getWindow3().getArea();
        value += wall.getWindow4().getArea();
        value += wall.getWindow5().getArea();
        return value;
    }
    public String wallHoles(Wall wall){
        String s = holeOutput(wall.getDoor1());
        s += holeOutput(wall.getDoor2());
        s += holeOutput(wall.getDoor3());
        s += holeOutput(wall.getDoor4());
        s += holeOutput(wall.getDoor5());
        s += holeOutput(wall.getWindow1());
        s += holeOutput(wall.getWindow2());
        s += holeOutput(wall.getWindow3());
        s += holeOutput(wall.getWindow4());
        s += holeOutput(wall.getWindow5());
        return s;
    }
    public String holeOutput(Hole hole){
        if(hole.getQuality()==-2)
            return "";
        else
            return  hole.toString() + " = " + roundOff2((hole.getArea() * setQuality(hole.getQuality())) * getMaterialPrice(hole.getType()))+"€\n";

    }
    public double holeCalculateCost(Wall wall){
        double s = holeCost(wall.getDoor1());
        s += holeCost(wall.getDoor2());
        s += holeCost(wall.getDoor3());
        s += holeCost(wall.getDoor4());
        s += holeCost(wall.getDoor5());
        s += holeCost(wall.getWindow1());
        s += holeCost(wall.getWindow2());
        s += holeCost(wall.getWindow3());
        s += holeCost(wall.getWindow4());
        s += holeCost(wall.getWindow5());
        return s;
    }
    public double holeCost(Hole hole){
        if(hole.getQuality()==-2)
            return 0d;
        return hole.getArea() * setQuality(hole.getQuality()) * getMaterialPrice(hole.getType());
    }
    public String roundOff2(double val){
        return String.format("%.2f", val);
    }


    public static boolean validType(String type){
        for(Material m : materials){
            if(m.getName().equals(type))
                return true;
        }
        return false;
    }
    public static void addMaterial(String name, double price, boolean forBase, boolean forDoor, boolean forWindow){
        materials.add(new Material(name, price, forBase, forDoor, forWindow));
    }
    public static boolean deleteMaterial(String name){
        for(Material m : materials){
            if(m.getName().equals(name)){
                materials.remove(m);
                return true;
            }
        }
        return false;
    }
    public static double getMaterialPrice(String name){
        for(Material m : materials){
            if(m.getName().equals(name))
                return m.getPrice();
        }
        return 0d;
    }
    public static void printMaterial(){
        for(Material m : materials){
            System.out.println(m.getName() + " " +m.getPrice());
        }
    }
}
