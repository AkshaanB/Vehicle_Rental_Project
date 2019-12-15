package Manager;

import java.util.Objects;
public class Car extends Vehicle {
    private int noOfDoors;
    private int noOfSeats;
    private String hybridStatus;

    public Car(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, int yearOfProduction, int noOfDoors, int noOfSeats,String hybridStatus) {
        super(plateNumber, make, model,color, capacity, transmission, fuelType, yearOfProduction);
        this.noOfDoors = noOfDoors;
        this.noOfSeats = noOfSeats;
        this.hybridStatus = hybridStatus;
    }

    public Car(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, int yearOfProduction, Schedule bookVehicle, int noOfDoors,int noOfSeats, String hybridStatus) {
        super(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction, bookVehicle);
        this.noOfDoors = noOfDoors;
        this.noOfSeats = noOfSeats;
        this.hybridStatus = hybridStatus;
    }

    public Car(String plateNumber, String make, String model, String color, String capacity, String transmission, String fuelType, Schedule pickUpDropOff, int yearOfProduction, int noOfDoors,int noOfSeats, String hybridStatus) {
        super(plateNumber, make, model, color, capacity, transmission, fuelType, pickUpDropOff, yearOfProduction);
        this.noOfDoors = noOfDoors;
        this.noOfSeats = noOfSeats;
        this.hybridStatus = hybridStatus;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }


    public String getHybridStatus() {
        return hybridStatus;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return noOfDoors == car.noOfDoors &&
                noOfSeats == car.noOfSeats &&
                hybridStatus.equals(car.hybridStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), noOfDoors, noOfSeats, hybridStatus);
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
                ", bookVehicle=" + bookVehicle +
                ", pickUpDropOff=" + pickUpDropOff +
                ", noOfDoors=" + noOfDoors +
                ", noOfSeats=" + noOfSeats +
                ", hybridStatus='" + hybridStatus +
                '}';
    }
}
