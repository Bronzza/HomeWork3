package com.company.repin.cargarrage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Car {
    private final String creationDate;
    private String engineType = "Petrol";
    private int maxSpeed = 200;
    private int timeTillHundred = 9;
    private int passengersQuantity = 5;
    private int passengersInside = 1;
    private int currentSpeed = 0;
    private CarDoor[] doors;
    private CarWheel[] wheels;

    private Car() {
        creationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yy")).toString();
        initiallizeArrays();
    }

    public Car(String creationDate, String engineType, int maxSpeed, int timeTillHundred, int passengersQuantity,
               int passengersInside, int currentSpeed) {
        this.creationDate = creationDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.timeTillHundred = timeTillHundred;
        this.passengersQuantity = passengersQuantity;
        this.passengersInside = passengersInside;
        this.currentSpeed = currentSpeed;
        initiallizeArrays();
    }

    public String getEngineType() {
        return engineType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getTimeTillHundred() {
        return timeTillHundred;
    }

    public int getPassengersQuantity() {
        return passengersQuantity;
    }

    public int getPassengersInside() {
        return passengersInside;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int setCurrentSpeed(int newCurrentSpeed) {
        if ((newCurrentSpeed < 0) || (newCurrentSpeed > maxSpeed)) {
            System.out.println("Input number from 0 to " + maxSpeed);
            return currentSpeed;
        }
        return currentSpeed = newCurrentSpeed;
    }

    public void addPassenger() {
        if (passengersInside <= passengersQuantity) {
            System.out.println("Passenger is added");
            passengersInside++;
        } else {
            System.out.println("Car is full");
        }
    }

    public void removePassenger() {
        if (passengersInside > 0) {
            System.out.println("Passenger is removed");
            passengersInside--;
        } else {
            System.out.println("Car is empty");
        }
    }

    public void removeAllPassenger() {
        passengersInside = 0;
    }

    public CarDoor getCarDoorIndex(int index) {
        if ((index > 0) || (index < doors.length - 1)) {
            return doors[index];
        }
        System.err.println("Fail");
        System.out.println("Input index between 0 and " + (doors.length - 1));
        return null;
    }

    public CarWheel getCarWheelIndex(int index) {
        if ((index > 0) || (index < wheels.length - 1)) {
            return wheels[index];
        }
        System.err.println("Fail");
        System.out.println("Input index between 0 and " + (wheels.length - 1));
        return null;
    }

    public void removeAllWheels() {
        System.out.println("Wheel were removed");
        wheels = new CarWheel[0];
    }

    public void addWheels(int wheelsNumber) {
        CarWheel[] temp;
        temp = new CarWheel[wheels.length + wheelsNumber];
        System.arraycopy(wheels, 0, temp, 0, wheels.length);
        wheels = temp;
        fillWheelsArray();
        System.out.println("Number of wheels was increase by " + wheelsNumber + ".\nCurrent number of wheels is: "
                + (wheels.length));

    }

    public int evaluetaMaxSpeed() {
        float minTireBlur = 1;
        if (passengersInside == 0) {
            System.out.println("No passengers inside");
            return 0;
        } else if (wheels.length == 0) {
            System.out.println("No wheels in your car maaan");
            return 0;
        }
        for (int i = 0; i < wheels.length; i++) {
            if (wheels[i] != null) {
                if (wheels[i].getTireState() < minTireBlur) {
                    minTireBlur = wheels[i].getTireState();
                }
            }
        }
        return maxSpeed *= minTireBlur;
    }


    private void fillWheelsArray() {
        for (int i = 0; i < wheels.length; i++) {
            if (wheels[i] == null) {
                wheels[i] = new CarWheel();
            }
        }
    }

    private void fillDoorsArray() {
        for (int i = 0; i < doors.length; i++) {
            if (doors[i] == null) {
                doors[i] = new CarDoor();
            }
        }
    }

    private void initiallizeArrays() {
        doors = new CarDoor[4];
        wheels = new CarWheel[4];
        fillDoorsArray();
        fillWheelsArray();
    }

    @Override
    public String toString() {
        return "This is Car, which is made in: " + creationDate + "; Engine is: " + engineType + "; maxspeed is: " +
                evaluetaMaxSpeed() + "; time till 100 km/h is: " + timeTillHundred + "; Current speed is: "
                + currentSpeed + " \nMax passengers " + "number is: " + passengersQuantity;
    }

    // first change for commit to master
    // second change for commit to master
    // third change for commit to master

    // first change for commit to secondBranch
    //first change for commit to secondBranch
    //third change for commit to secondBranch
}
