package com.example.demo.Manager;

public interface RentalVehicleManager {
    boolean addVehicle(Vehicle vehicle) throws Exception;
    boolean deleteVehicle(Vehicle vehicle);
    boolean listOfVehicle();
    boolean save();
    boolean bookVehicle(Vehicle vehicle);
    boolean checkAvailability(Vehicle vehicle);
    void sortVehicles();
    void generateReport();
}
