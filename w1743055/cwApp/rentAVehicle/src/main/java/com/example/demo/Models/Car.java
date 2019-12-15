package com.example.demo.Models;

import java.util.Objects;

public class Car {
    protected String plateNumber;
    protected String make;
    protected String model;
    protected String color;
    protected String capacity;
    protected String transmission;
    protected String fuelType;
    protected int yearOfProduction;
    protected int noOfDoors;
    protected int noOfSeats;
    protected String hybridStatus;

    public Car() {
    }

    public Car(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, int yearOfProduction, int noOfDoors, int noOfSeats, String hybridStatus) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.capacity = capacity;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.yearOfProduction = yearOfProduction;
        this.noOfDoors = noOfDoors;
        this.noOfSeats = noOfSeats;
        this.hybridStatus = hybridStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfProduction == car.yearOfProduction &&
                noOfDoors == car.noOfDoors &&
                noOfSeats == car.noOfSeats &&
                plateNumber.equals(car.plateNumber) &&
                make.equals(car.make) &&
                model.equals(car.model) &&
                color.equals(car.color) &&
                capacity.equals(car.capacity) &&
                transmission.equals(car.transmission) &&
                fuelType.equals(car.fuelType) &&
                hybridStatus.equals(car.hybridStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction, noOfDoors, noOfSeats, hybridStatus);
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", noOfDoors=" + noOfDoors +
                ", noOfSeats=" + noOfSeats +
                ", hybridStatus='" + hybridStatus + '\'' +
                '}';
    }
}
