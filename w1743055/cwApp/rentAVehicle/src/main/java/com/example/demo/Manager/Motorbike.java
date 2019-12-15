package com.example.demo.Manager;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Objects;
@CrossOrigin(origins = "http://localhost:4400")
@Document(collection = "Vehicles")
public class Motorbike extends Vehicle {
    protected String startType;
    protected String bikeType;

    public Motorbike(){
        super();
    }

    public Motorbike(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, int yearOfProduction, String startType, String bikeType) {
        super(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction);
        this.startType = startType;
        this.bikeType = bikeType;
    }

//    public Motorbike(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, int yearOfProduction, Schedule bookVehicle, String startType, String bikeType) {
//        super(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction, bookVehicle);
//        this.startType = startType;
//        this.bikeType = bikeType;
//    }
//
//    public Motorbike(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, Schedule pickUpDropOff, int yearOfProduction, String startType, String bikeType) {
//        super(plateNumber, make, model, color, capacity, transmission, fuelType, pickUpDropOff, yearOfProduction);
//        this.startType = startType;
//        this.bikeType = bikeType;
//    }

    public String getStartType() {
        return startType;
    }

    public String getBikeType() {
        return bikeType;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motorbike motorbike = (Motorbike) o;
        return startType.equals(motorbike.startType) &&
                bikeType.equals(motorbike.bikeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), startType, bikeType);
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                ", plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", capacity='" + capacity + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", bookVehicle=" + bookVehicle +
                ", pickUpDropOff=" + pickUpDropOff +
                ", startType='" + startType +
                ", bikeType='" + bikeType +
                '}';
    }
}

