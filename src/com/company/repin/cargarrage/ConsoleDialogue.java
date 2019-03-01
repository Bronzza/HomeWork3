package com.company.repin.cargarrage;

import java.util.Scanner;

public class ConsoleDialogue {
    boolean generalDialogue = true;


    public Car consoleCarModifier() {
        Scanner scanner = new Scanner(System.in);
        Car result = null;
        while (generalDialogue) {
            if (result == null) {
                System.out.println("Creating Car");
                result = createCarConsole();
                continue;
            } else {
                System.out.println("Modify Car / Display Car info / Exit (m/d/e)");
            }
            String answer = scanner.nextLine();
            switch (answer) {
                case ("e"):
                case ("E"):
                    generalDialogue = false;
                case ("d"):
                case ("D"):
                    System.out.println(result.toString());
                    break;
                case ("m"):
                case ("M"):
                    modifyCarInter(result);
                    break;
                default:
                    System.err.println("Input \"m\" or \"d\" or \"e\"");
                    break;
            }
        }
        return null;
    }

    private Car createCarConsole() {
        Car result;
        String creationDate;
        String engineType = "Petrol";
        int maxSpeed = 200;
        int timeTillHundred = 9;
        int passengersQuantity = 5;
        int passengersInside = 0;
        int currentSpeed = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date of Car creation, format is \"dd-MM-YY\"");
        creationDate = scanner.nextLine();
        System.out.println("Enter type of the engine Petrol/Disel");
        engineType = scanner.nextLine();
        System.out.println("Enter max speed of the Car (number below 500)");
        maxSpeed = scanner.nextInt();
        System.out.println("Enter time need to get 100 km/h (number below 50)");
        timeTillHundred = scanner.nextInt();
        System.out.println("Enter passengers capacity (number below 20)");
        passengersQuantity = scanner.nextInt();
        System.out.println("Enter number of passengers inside the car at the moment (number below "
                + passengersQuantity + ")");
        passengersInside = scanner.nextInt();
        result = new Car(creationDate, engineType, maxSpeed, timeTillHundred, passengersQuantity, passengersInside,
                currentSpeed);
        System.out.println("Car is created!");

        return result;
    }


    private Car modifyCarInter(Car car) {

        boolean modifyDialogue = true;
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.println("You are in modify menu. Chose what do you want to change");
        System.out.println("Change current speed - \"c\"");
        System.out.println("Add passenger - \"a\"");
        System.out.println("Remove passenger - \"r\"");
        System.out.println("Modify door by index - \"md\"");
        System.out.println("Modify wheel by index - \"mw\"");
        System.out.println("Remove all the wheels - \"wr\"");
        System.out.println("Add wheels - \"wa\"");
        System.out.println("Exit to previous menu - \"e\"");

        while (modifyDialogue) {
            answer = scanner.nextLine();
            switch (answer) {
                case ("e"):
                case ("E"):
                    modifyDialogue = false;
                    break;
                case ("c"):
                case ("C"):
                    System.out.println("Enter new current speed");
                    car.setCurrentSpeed(new Scanner(System.in).nextInt());
                    break;
                case ("a"):
                case ("A"):
                    car.addPassenger();
                    break;
                case ("r"):
                case ("R"):
                    car.removePassenger();
                    break;
                case ("md"):
                case ("MD"):
                    System.out.println("Enter door index number");
                    doorDialogue(car.getCarDoorIndex(new Scanner(System.in).nextInt()));
                    break;
                case ("mw"):
                case ("MW"):
                    System.out.println("Enter wheel index number");
                    wheelDialogue(car.getCarWheelIndex(new Scanner(System.in).nextInt()));
                    break;
                case ("wr"):
                case ("WR"):
                    car.removeAllWheels();
                    break;
                case ("wa"):
                case ("WA"):
                    System.out.println("Enter number of wheel to add");
                    car.addWheels(new Scanner(System.in).nextInt());
                    break;
                default:
                    System.err.println("Enter please \"c\", \"a\", \"r\", \"md\", \"mw\", \"wr\"," +
                            "\"wa\" or  \"e\"");
                    break;
            }
            if (modifyDialogue == true) {
                System.out.println("You are in modify menu");
                System.out.println("Enter please: Change current speed - \"c\"; Add passenger - \"a\"; Remove passenger" +
                        " - \"r\"; Modify door - \"md\"; Modify wheel - \"mw\"; Remove all wheels -  \"wr\";" +
                        " Add wheels - \"wa\" or Exit \"e\"");
            }
        }
        return car;
    }

    private void doorDialogue(CarDoor door) {
        boolean doorModifyDialogue = true;
        Scanner scanner1 = new Scanner(System.in);
        String answer;
        System.out.println("You are in DOOR modify menu. Chose what do you want to change");
        System.out.println("Open the door - " + 1);
        System.out.println("Close the door - " + 2);
        System.out.println("Open window - " + 3);
        System.out.println("Close window - " + 4);
        System.out.println("Info about the door - " + 5);
        System.out.println("Exit to previous menu - " + 6);

        while (doorModifyDialogue) {

            answer = scanner1.nextLine();
            switch (Integer.parseInt(answer)) {
                case (6):
                    doorModifyDialogue = false;
                    break;
                case (1):
                    door.openTheDoor();
                    break;
                case (2):
                    door.closeTheDoor();
                    break;
                case (3):
                    door.openTheWindow();
                    break;
                case (4):
                    door.closeTheWindow();
                    break;
                case (5):
                    System.out.println(door.toString());
                    break;
                default:
                    System.err.println("Enter please: Open the door - \"1\"; Close the door - \"2\"; Open window  -\"3\";" +
                            " Close window  - \"4\"; Info about the door -  \"5\" or  Exit to previous men - \"6\"");
                    break;
            }
            if (doorModifyDialogue == true) {
                System.out.println("You are in DOOR modify menu");
                System.out.println("Enter please: Open the door - \"1\"; Close the door - \"2\"; Open window  -\"3\";" +
                        " Close window  - \"4\"; Info about the door -  \"5\" or  Exit to previous men - \"6\"");
            }
        }
    }

    private void wheelDialogue(CarWheel wheel) {
        boolean wheelModifyDialogue = true;
        Scanner scanner = new Scanner(System.in);
        String answer;
        System.out.println("Set new tire - \"s\"");
        System.out.println("Erase tire  - \"e\"");
        System.out.println("Get info about tire state \"t\"");
        System.out.println("Get info about this wheel \"i\"");
        System.out.println("Exit to previous menu - \"x\"");


        while (wheelModifyDialogue) {
            answer = scanner.nextLine();
            switch (answer) {
                case ("x"):
                case ("X"):
                    wheelModifyDialogue = false;
                    break;
                case ("s"):
                case ("S"):
                    wheel.setNewTire();
                    break;
                case ("e"):
                case ("E"):
                    System.out.println("Input number between 0 and 100");
                    wheel.changeTireState(new Scanner(System.in).nextInt());
                    break;
                case ("t"):
                case ("T"):
                    System.out.println("Tire stait is " + wheel.getTireState() * 100 + "%");
                    break;
                case ("i"):
                case ("I"):
                    System.out.println(wheel.toString());
                    break;
                default:
                    System.err.println("Enter please: \"s\"- Set new tire, \"e\" - Erase tire, \"t\" - Get info about "
                            + "tire state, \"i\" - Get info about this wheel  or  \"x\" - Exit to previous menu");
                    break;
            }
            if (wheelModifyDialogue == true) {
                System.out.println("You are in WHEEL modify menu");
                System.out.println("Enter please: \"s\"- Set new tire, \"e\" - Erase tire, \"t\" - Get info about " +
                        "tire state, \"i\" - Get info about this wheel  or  \"x\" - Exit to previous menu");
            }
        }
    }


}
