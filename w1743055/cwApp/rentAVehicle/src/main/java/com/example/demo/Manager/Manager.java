package com.example.demo.Manager;

import com.example.demo.Manager.MakeComparator;
import com.example.demo.Manager.Motorbike;
import com.example.demo.Manager.Vehicle;
import com.example.demo.Manager.WestminsterRentalVehicleManager;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Manager {
    private static WestminsterRentalVehicleManager manager = new WestminsterRentalVehicleManager();
    private static Scanner input = new Scanner(System.in);
    private static Scanner input1 = new Scanner(System.in);
    private static Scanner input2 = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Select option:");
        System.out.println("  1) Add Vehicle");
        System.out.println("  2) Delete Vehicle");
        System.out.println("  3) Print List of items");
        System.out.println("  4) Save");
        System.out.println("  5) Generate Report");
        System.out.println("  6) Search Vehicle or View Vehicle/s");
        System.out.println("  7) Exit");
        System.out.print("Enter option: ");
        int option = getInteger(input);
        while (!(option>=1 && option<=7)){
            System.err.println("Invalid input!");
            System.out.print("Please reenter: ");
            option = getInteger(input);
        }
        while (true) {
            switch (option) {
                case 1:
                    System.out.println("---Add Vehicle---");
                    System.out.println("Select type of vehicle to be added: ");
                    System.out.println("  1) Car");
                    System.out.println("  2) Motorbike");
                    System.out.print("Enter type: ");
                    int type = getInteger(input);
                    while (!(type==1 || type==2)){
                        System.err.println("Invalid input!");
                        System.out.print("Please reenter: ");
                        type = getInteger(input);
                    }
                    if (type == 1) {
                        System.out.print("Plate number: ");
                        String plateNumber = input1.next();
                        System.out.print("Make: ");
                        String make = input2.next();
                        System.out.print("Model: ");
                        String model = input1.next();
                        System.out.print("Color: ");
                        String color = input2.next();
                        System.out.print("Capacity (When entering type 'cc' at the end): ");
                        String capacity = input2.nextLine();
                        while (!capacity.contains("cc")){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            capacity = input1.next();
                        }
                        System.out.print("Transmission: ");
                        String transmission = input1.nextLine();
                        while (!((transmission.equalsIgnoreCase("auto")|| (transmission.equalsIgnoreCase("manual"))))){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            transmission = input1.next();
                        }
                        System.out.print("Fuel Type: ");
                        String fuelType = input2.nextLine();
                        while (!((fuelType.equalsIgnoreCase("diesel")|| (fuelType.equalsIgnoreCase("petrol"))))){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            fuelType = input1.next();
                        }
                        System.out.print("Year of Production: ");
                        int yearOfProduction = getInteger(input);
                        while (!(yearOfProduction<=2019)){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            yearOfProduction = input1.nextInt();
                        }
                        System.out.print("No. of doors: ");
                        int noOfDoors = getInteger(input1);
                        while (!(noOfDoors<6 && noOfDoors>1)){
                            System.err.println("Invalid input!. Cars cannot have "+ noOfDoors+ " of doors");
                            System.out.print("Please renter: ");
                            noOfDoors = input1.nextInt();
                        }
                        System.out.print("No. of Seats: ");
                        int noOfSeats = getInteger(input1);
                        while (!(noOfSeats<10 && noOfSeats>=2)){
                            System.err.println("Invalid input!. Cars cannot have "+ noOfSeats+ " of doors");
                            System.out.print("Please renter: ");
                            noOfSeats = input1.nextInt();
                        }
                        System.out.print("Hybrid status (If hybrid enter 'Hybrid', else enter 'Non hybrid' : ");
                        String hybridStatus = input2.next();
                        while (!((hybridStatus.equalsIgnoreCase("hybrid")|| (hybridStatus.equalsIgnoreCase("non hybrid"))))){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            hybridStatus = input1.next();
                        }
                        Vehicle vehicle = new Car(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction, noOfDoors,noOfSeats, hybridStatus);
                        manager.addVehicle(vehicle);
                    } else {
                        System.out.print("Plate number: ");
                        String plateNumber = input1.next();
                        System.out.print("Make: ");
                        String make = input1.next();
                        System.out.print("Model: ");
                        String model = input1.next();
                        System.out.print("Color: ");
                        String color = input2.next();
                        System.out.print("Capacity (When entering type 'cc' at the end): ");
                        String capacity = input2.next();
                        while (!capacity.contains("cc")){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            capacity = input1.next();
                        }
                        System.out.print("Transmission: ");
                        String transmission = input1.next();
                        while (!((transmission.equalsIgnoreCase("auto")|| (transmission.equalsIgnoreCase("manual"))))){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            transmission = input1.next();
                        }
                        System.out.print("Fuel Type: ");
                        String fuelType = input2.next();
                        while (!((fuelType.equalsIgnoreCase("diesel")|| (fuelType.equalsIgnoreCase("petrol"))))){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            fuelType = input1.next();
                        }
                        System.out.print("Year of Production: ");
                        int yearOfProduction = getInteger(input);
                        while (!(yearOfProduction<=2019)){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            yearOfProduction = input1.nextInt();
                        }
                        System.out.print("Start Type (Enter 'Push' if push start, else 'Key' if key start): ");
                        String startType = input2.next();
                        while (!((startType.equalsIgnoreCase("push")|| (startType.equalsIgnoreCase("key"))))){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            startType = input1.next();
                        }
                        System.out.print("Bike Type (Enter 'Scooty' if scooty type bike, else 'Normal' if not scooty type): ");
                        String bikeType = input1.next();
                        while (!((bikeType.equalsIgnoreCase("scooty")|| (bikeType.equalsIgnoreCase("normal"))))){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            bikeType = input1.next();
                        }
                        Vehicle vehicle = new Motorbike(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction, startType, bikeType);
                        manager.addVehicle(vehicle);
               }
                    break;
                case 2:
                    System.out.print("Enter plate number: ");
                    String plateNumber = input2.next();
                    boolean found = false;
                    for (Vehicle vehicle : manager.getVehicles()) {
                        if (plateNumber.equals(vehicle.getPlateNumber())) {
                            manager.deleteVehicle(vehicle);
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Vehicle with the plate number: "+plateNumber+" not found!");
                    }
                    break;
                case 3:
                    if(manager.getVehicles().size()==0){
                        System.out.println("---No Vehicles!---");
                    }else {
                        System.out.println("-----Vehicles-----");
                        manager.getVehicles().sort(new MakeComparator());
                        for (Vehicle vehicle : manager.getVehicles()) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case 4:
                    manager.save();
                    break;
                case 5:
                    manager.generateReport();
                    break;
                case 6:
                    try {
                        URI uri = new URI("http://localhost:4200/loginSignUp-home/search");
                        java.awt.Desktop.getDesktop().browse(uri);
                    } catch (URISyntaxException | IOException e) {
                        System.out.println("Exception");
                    }
                    break;
                case 7:
                    System.out.println("---Program quits!---");
                    System.exit(0);
                default:
                    System.out.println("Select option:");
                    System.out.println("  1) Add Vehicle");
                    System.out.println("  2) Delete Vehicle");
                    System.out.println("  3) Print List of items");
                    System.out.println("  4) Save");
                    System.out.println("  5) Generate Report");
                    System.out.println("  6) Search Vehicle or View Vehicle/s");
                    System.out.println("  7) Exit");
                    System.out.print("Enter option: ");
                    option = getInteger(input);
                    continue;
            }
            System.out.println("Select option:");
            System.out.println("  1) Add Vehicle");
            System.out.println("  2) Delete Vehicle");
            System.out.println("  3) Print List of items");
            System.out.println("  4) Save");
            System.out.println("  5) Generate Report");
            System.out.println("  6) Search Vehicle or View Vehicle/s");
            System.out.println("  7) Exit");
            System.out.print("Enter option: ");
            option = getInteger(input);
        }
    }
    private static int getInteger(Scanner input){
        while (!input.hasNextInt()){
            System.err.println("Invalid input!");
            System.out.print("Please reenter: ");
            input.next();
        }
        return input.nextInt();
    }
}
