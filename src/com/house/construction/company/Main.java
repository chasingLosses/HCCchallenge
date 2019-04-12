package com.house.construction.company;

import java.awt.*;
import java.util.Scanner;

public class Main {
    private static House house = new House();;
    private static Bom bom = new Bom();
    //Input and output
    private static Scanner sc = new Scanner(System.in);
    private static String greeting = "Hello and welcome to HCC\u2122!\nThis program will help you design a house, " +
            "and remember, the customer is always right!";
    private static String mainMenu = "Choose:\n1 - Build a house\n2 - Edit house\n3 - " +
            "Show current price\n4 - Edit material\n5 - Make a sale\n6 - Exit program";
    private static String editMenu = "Choose:\n1 - Edit Wall\n2 - Edit Roof\n3 - Edit Door\n4 - Edit Window";
    private static String editDoorMenu = "Choose:\n1 - Add door\n2 - Edit door\n3 - Delete door";
    private static String editWindowMenu = "Choose:\n1 - Add window\n2 - Edit window\n3 - Delete window";
    private static String materialMenu = "Choose:\n1 - Add material\n2 - Delete material";
    private static String end = "Thank you for using HCC\u2122. Have a nice day!";

    public static void main(String[] args) {
        bom.materials.add(new Material("Concrete",25d,true,false, false));

        System.out.println(greeting);
        while(true){
            System.out.println(mainMenu);
            switch(sc.nextInt()){
                case 1:
                    System.out.println(buildHouse());
                    break;
                case 2:
                    System.out.println(editHouse());
                    break;
                case 3:
                    System.out.println(showCurrentPrice());
                    break;
                case 4:
                    System.out.println(editMaterial());
                    break;
                case 5:
                    System.out.println(makeASale());
                    break;
                case 6:
                    System.out.println(end);
                    System.exit(0);
            }
        }
    }


    public static String buildHouse(){
        System.out.println("Input dimensions for four walls and a roof.");
        house = new House(new Wall(createRoof()),new Wall(createRoof()),new Wall(createRoof()),new Wall(createRoof()),createRoof());
        return"House built successfully!";
    }
    private static Roof createRoof(){
        System.out.print("Input width: ");
        double width = setValidDimension();
        System.out.print("Input length: ");
        double length = setValidDimension();
        System.out.print("Input quality: ");
        int quality = setValidQuality();
        System.out.print("Input type: ");
        String type = setValidType();
        return new Roof (width,length,quality,type);
    }
    private static double setValidDimension(){
        while(true){
            double check = sc.nextDouble();
            if(House.validDimension(check))
                return check;
            else
                System.out.println("Invalid input, a value greater then zero expected");
        }
    }
    private static int setValidQuality(){
        while(true){
            int check = sc.nextInt();
            if(House.validQuality(check))
                return check;
            else
                System.out.println("Invalid quality, values -1, 0, 1 expected");
        }
    }


    public static String editHouse(){
        while(true) {
            System.out.println(editMenu);
            switch (sc.nextInt()) {
                case 1:
                    editWall(chooseWall());
                    System.out.println("Wall edited successfully");
                    break;
                case 2:
                    editWall(house.getRoof());
                    System.out.println("Roof edited successfully!");
                    break;
                case 3:
                    System.out.println(editDoor());
                    break;
                case 4:
                    System.out.println(editWindow());
                    break;
            }
            System.out.println("Would you like to edit again? (Y/N)");
            if(!sc.next().equals("Y"))
                break;
        }
        return "House edited successfully, exiting house editor!";
    }
    public static Wall chooseWall() {
        System.out.println("Which wall would you like to select?\n1 - Wall\n2 - Wall\n3 - Wall\n4 - Wall");
        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return house.getWall1();
                case 2:
                    return house.getWall2();
                case 3:
                    return house.getWall3();
                case 4:
                    return house.getWall4();
            }
            System.out.println("Wrong input 1, 2, 3, or 4 expected.");
        }
    }
    private static void editWall(Roof wall){
        System.out.println("Current width is: " + wall.getWidth() + ", current length/height is: " + wall.getLength() + ", current quality is: " + wall.getQuality());
        System.out.print("Input new width: ");
        wall.setWidth(setValidDimension());
        System.out.print("Input new length/height: ");
        wall.setLength(setValidDimension());
        System.out.print("Input new quality: ");
        wall.setQuality(setValidQuality());
        System.out.print("Input new type: ");
        wall.setType(setValidType());

    }
    public static String editDoor() {
        while (true) {
            System.out.println(editDoorMenu);
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Add doors to which wall?");
                    setAvailableDoor(chooseWall());
                    return "Exiting door editor";
                case 2:
                    System.out.println("Edit doors on which wall?");
                    setAvailableDoor(chooseWall());
                    return "Exiting door editor";
                case 3:
                    System.out.println("Delete doors on which wall?");
                    deleteDoor(chooseWall());
                    return "Exiting door editor";
            }
            System.out.println("Wrong input 1, 2, or 3 expected.");
        }
    }
    public static void setAvailableDoor(Wall wall){
        System.out.println(wall.toString());
        if(wall.getDoor1().getQuality() == -2){
            wall.setDoor1(new Door(createHole()));
        }else if(wall.getDoor2().getQuality() == -2){
            wall.setDoor2(new Door(createHole()));
        }else if(wall.getDoor3().getQuality() == -2){
            wall.setDoor3(new Door(createHole()));
        }else if(wall.getDoor4().getQuality() == -2){
            wall.setDoor4(new Door(createHole()));
        }else if(wall.getDoor5().getQuality() == -2){
            wall.setDoor5(new Door(createHole()));
        }else{
            System.out.println("The wall is already full of Doors, would you like to replace one of them?");
            if(sc.next().equals("Y")) {
                System.out.println("Choose the doors you would like to replace:");
                while(true){
                    int choice = sc.nextInt();
                    switch(choice) {
                        case 1:
                            wall.setDoor1(new Door(createHole()));
                            break;
                        case 2:
                            wall.setDoor2(new Door(createHole()));
                            break;
                        case 3:
                            wall.setDoor3(new Door(createHole()));
                            break;
                        case 4:
                            wall.setDoor4(new Door(createHole()));
                            break;
                        case 5:
                            wall.setDoor5(new Door(createHole()));
                            break;
                    }
                    if(choice > 5 || choice < 1)
                        System.out.println("Wrong input 1, 2, 3, 4 or 5 expected.");
                    else
                        break;
                }
            }
        }
    }
    private static Hole createHole(){
        System.out.print("Input width: ");
        double width = setValidDimension();
        System.out.print("Input length: ");
        double length = setValidDimension();
        System.out.print("Input quality: ");
        int quality = setValidQuality();
        System.out.print("Input color: ");
        String color = setValidColor();
        System.out.print("Input type: ");
        String type = setValidType();
        return new Hole(width,length,color,quality,type);
    }
    private static String setValidColor(){
        while(true){
            String check = sc.next();
            if(House.validColor(check))
                return check;
            else
                System.out.println("Please enter a color.");
        }
    }
    private static String setValidType(){
        while(true){
            String check = sc.next();
            if(Bom.validType(check))
                return check;
            else
                System.out.println("Please enter a valid type.");
        }
    }
    public static void deleteDoor(Wall wall){
        System.out.println(wall.toString() + "\nChoose the doors you would like to delete:");
        while(true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    wall.setDoor1(new Door());
                    break;
                case 2:
                    wall.setDoor2(new Door());
                    break;
                case 3:
                    wall.setDoor3(new Door());
                    break;
                case 4:
                    wall.setDoor4(new Door());
                    break;
                case 5:
                    wall.setDoor5(new Door());
                    break;
            }
            if (choice > 5 || choice < 1)
                System.out.println("Wrong input 1, 2, 3, 4 or 5 expected.");
            else
                break;
        }
    }
    public static String editWindow() {
        while (true) {
            System.out.println(editWindowMenu);
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Add window to which wall?");
                    setAvailableWindow(chooseWall());
                    return "Exiting window editor";
                case 2:
                    System.out.println("Edit window on which wall?");
                    setAvailableWindow(chooseWall());
                    return "Exiting window editor";
                case 3:
                    System.out.println("Delete window on which wall?");
                    deleteWindow(chooseWall());
                    return "Exiting window editor";
            }
            System.out.println("Wrong input 1, 2, or 3 expected.");
        }
    }
    public static void setAvailableWindow(Wall wall){
        System.out.println(wall.toString());
        if(wall.getWindow1().getQuality() == -2){
            wall.setWindow1(new Window(createHole()));
        }else if(wall.getWindow2().getQuality() == -2){
            wall.setWindow2(new Window(createHole()));
        }else if(wall.getWindow3().getQuality() == -2){
            wall.setWindow3(new Window(createHole()));
        }else if(wall.getWindow4().getQuality() == -2){
            wall.setWindow4(new Window(createHole()));
        }else if(wall.getWindow5().getQuality() == -2){
            wall.setWindow5(new Window(createHole()));
        }else{
            System.out.println("The wall is already full of windows, would you like to replace one of them?");
            if(sc.next().equals("Y")) {
                System.out.println("Choose the window you would like to replace:");
                while(true){
                    int choice = sc.nextInt();
                    switch(choice) {
                        case 1:
                            wall.setWindow1(new Window(createHole()));
                            break;
                        case 2:
                            wall.setWindow2(new Window(createHole()));
                            break;
                        case 3:
                            wall.setWindow3(new Window(createHole()));
                            break;
                        case 4:
                            wall.setWindow4(new Window(createHole()));
                            break;
                        case 5:
                            wall.setWindow5(new Window(createHole()));
                            break;
                    }
                    if(choice > 5 || choice < 1)
                        System.out.println("Wrong input 1, 2, 3, 4 or 5 expected.");
                    else
                        break;
                }
            }
        }
    }
    public static void deleteWindow(Wall wall){
        System.out.println(wall.toString() + "\nChoose the window you would like to delete:");
        int choice = sc.nextInt();
        if(choice == 1)
            wall.setWindow1(new Window());
        else if(choice == 2)
            wall.setWindow2(new Window());
        else if(choice == 3)
            wall.setWindow3(new Window());
        else if(choice == 4)
            wall.setWindow4(new Window());
        else if(choice == 5)
            wall.setWindow5(new Window());
    }


    private static String editMaterial(){
        while (true) {
            System.out.println(materialMenu);
            switch (sc.nextInt()) {
                case 1:
                    addMaterial();
                    return "Exiting material editor";
                case 2:
                    deleteMaterial();
                    return "Exiting door editor";
            }
            System.out.println("Wrong input 1, or 2 expected.");
        }
    }
    private static void addMaterial(){
        System.out.println("Input material name: ");
        String name = setValidMaterial();
        System.out.println("Input material price per m2: ");
        double price = setValidDimension();
        System.out.println("Is this type available for base? (Y/N)");
        boolean forBase = false;
        if(sc.next().equals("Y"))
            forBase = true;
        System.out.println("Is this type available for doors? (Y/N)");
        boolean forDoor = false;
        if(sc.next().equals("Y"))
            forDoor = true;
        System.out.println("Is this type available for windows? (Y/N)");
        boolean forWindow = false;
        if(sc.next().equals("Y"))
            forWindow = true;

        Bom.addMaterial(name, price, forBase, forDoor,forWindow);
    }
    private static void deleteMaterial(){
        Bom.printMaterial();
        System.out.println("Input material name: ");
        String name = setValidMaterial();
        if(Bom.deleteMaterial(name))
            System.out.println("Material deleted.");
        else
            System.out.println("No such material exists.");
    }
    private static String setValidMaterial(){
        String check = sc.next();
        return check;
    }


    private static String showCurrentPrice(){
        bom = new Bom(house, false, 0);
        if(bom.checkHouseStability().equals("OK")){
            House sample = new House(house.getWall1(),house.getWall2(),house.getWall3(),house.getWall4(),house.getRoof());
            Bom sampleHouse = new Bom(House.setQualityForAllElements(sample,1), false,0);
            System.out.println("\n\n\nPrice for prime quality:\n" + sampleHouse.showPrice()+ "\n\n\n");
            sampleHouse= new Bom(House.setQualityForAllElements(sample,0), false,0);
            System.out.println("Price for OK quality:\n" + sampleHouse.showPrice()+ "\n\n\n");
            sampleHouse = new Bom(House.setQualityForAllElements(sample,-1), false,0);
            System.out.println("Price for low quality:\n" + sampleHouse.showPrice()+ "\n\n\n");
            return bom.showPrice();
        }
        return bom.checkHouseStability();
    }

    private static String makeASale(){
        if(!bom.checkHouseStability().equals("OK"))
            return bom.checkHouseStability();
        System.out.println("We offer 10% discount for cash? (Y/N)");
        if(sc.next().equals("Y"))
            bom = new Bom(house, true, 0);
        else {
            System.out.println("In how many years would you like to pay us off?");
            bom = new Bom(house, false, (int) setValidDimension());
        }
        return bom.showPrice();
    }
}
