package com.example.demo.Models;


import com.example.demo.Manager.Schedule;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Inheritance;
import java.util.Objects;
public class Vehicle implements Comparable<com.example.demo.Manager.Vehicle>{
    protected Object objectId;
    protected String type;
    protected String plateNumber;
    protected String make;
    protected String model;
    protected String color;
    protected String capacity;
    protected String transmission;
    protected String fuelType;
    protected int yearOfProduction;


    public Vehicle(String type, String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, int yearOfProduction) {
        this.type = type;
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.capacity = capacity;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.yearOfProduction = yearOfProduction;
    }

    //    public Vehicle(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, int yearOfProduction, Schedule bookVehicle) {
//        super();
//        this.plateNumber = plateNumber;
//        this.make = make;
//        this.model = model;
//        this.color = color;
//        this.capacity = capacity;
//        this.transmission = transmission;
//        this.fuelType = fuelType;
//        this.yearOfProduction = yearOfProduction;
//        this.bookVehicle = bookVehicle;
//    }
//
//    public Vehicle(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, Schedule pickUpDropOff ,int yearOfProduction) {
//        super();
//        this.plateNumber = plateNumber;
//        this.make = make;
//        this.model = model;
//        this.color = color;
//        this.capacity = capacity;
//        this.transmission = transmission;
//        this.fuelType = fuelType;
//        this.yearOfProduction = yearOfProduction;
//        this.pickUpDropOff = pickUpDropOff;
//    }

    public String getPlateNumber() {
        return plateNumber;
    }


    public String getMake() {
        return make;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public String getCapacity() {
        return capacity;
    }


    public String getTransmission() {
        return transmission;
    }


    public String getFuelType() {
        return fuelType;
    }


    public int getYearOfProduction() {
        return yearOfProduction;
    }


//    public Schedule getBookVehicle() {
//        return bookVehicle;
//    }
//
//    public void setBookVehicle(Schedule bookVehicle) {
//        this.bookVehicle = bookVehicle;
//    }
//
//    public Schedule getPickUpDropOff() {
//        return pickUpDropOff;
//    }
//
//    public void setPickUpDropOff(Schedule pickUpDropOff) {
//        this.pickUpDropOff = pickUpDropOff;
//    }

    public String getModel() {
        return model;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return yearOfProduction == vehicle.yearOfProduction &&
                type.equals(vehicle.type) &&
                plateNumber.equals(vehicle.plateNumber) &&
                make.equals(vehicle.make) &&
                model.equals(vehicle.model) &&
                color.equals(vehicle.color) &&
                capacity.equals(vehicle.capacity) &&
                transmission.equals(vehicle.transmission) &&
                fuelType.equals(vehicle.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    @Override
    public int compareTo(com.example.demo.Manager.Vehicle o) {
        return this.getMake().compareTo(o.getMake());
    }
}
