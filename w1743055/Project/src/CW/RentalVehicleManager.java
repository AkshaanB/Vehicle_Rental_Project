package CW;

public interface RentalVehicleManager {
    boolean addVehicle(Vehicle vehicle); //the user can add vehicles to the system
    boolean deleteVehicle(Vehicle vehicle);//the user can delete vehicles to the system
    boolean listOfVehicle(); //the user can print the list of vehicles in the system
    boolean save(); //the user can save the changes to the system
    void generateReport(); //the user can generate a report of the recent changes
}
