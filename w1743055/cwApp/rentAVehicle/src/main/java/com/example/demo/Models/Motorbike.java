package com.example.demo.Models;

import java.util.Objects;

public class Motorbike {
    protected String plateNumber;
    protected String make;
    protected String model;
    protected String color;
    protected String capacity;
    protected String transmission;
    protected String fuelType;
    protected int yearOfProduction;
    protected String startType;
    protected String bikeType;

    public Motorbike() {
    }

    public Motorbike(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, int yearOfProduction, String startType, String bikeType) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.color = color;
        this.capacity = capacity;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.yearOfProduction = yearOfProduction;
        this.startType = startType;
        this.bikeType = bikeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorbike motorbike = (Motorbike) o;
        return yearOfProduction == motorbike.yearOfProduction &&
                plateNumber.equals(motorbike.plateNumber) &&
                make.equals(motorbike.make) &&
                model.equals(motorbike.model) &&
                color.equals(motorbike.color) &&
                capacity.equals(motorbike.capacity) &&
                transmission.equals(motorbike.transmission) &&
                fuelType.equals(motorbike.fuelType) &&
                startType.equals(motorbike.startType) &&
                bikeType.equals(motorbike.bikeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction, startType, bikeType);
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", startType='" + startType + '\'' +
                ", bikeType='" + bikeType + '\'' +
                '}';
    }
}
