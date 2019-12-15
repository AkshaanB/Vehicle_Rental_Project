package com.example.demo.Manager;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WestminsterRentalVehicleManager implements RentalVehicleManager {
    public static int spaces = 50;
    public static List<Vehicle> vehicles = new ArrayList<>(); //vehicles that are added contains in this list
    public static List<Vehicle> deletedVehicles = new ArrayList<>(); //vehicles that are deleted contains in this list
    private static File file = new File("Vehicles.txt");

    MongoClient mongoClient = new MongoClient("localhost",27017);
    MongoCredential credential = MongoCredential.createCredential("Akshaan","VehicleDatabase","akshaan123456".toCharArray());
    //Accessing Database
    MongoDatabase database = mongoClient.getDatabase("VehicleDatabase");

    @Override
    public boolean addVehicle(Vehicle vehicle){
        if (vehicles.size()<spaces) {
            vehicles.add(vehicle);
            spaces-=1;
            System.out.println(vehicle+" addition successful!");
            System.out.println("No of spaces used: "+getSpaces());
        }else {
            System.out.println("No space!");
        }
        return true;
    }

    @Override
    public boolean deleteVehicle(Vehicle vehicle) {
        deletedVehicles.add(vehicle);
        vehicles.remove(vehicle);
        spaces+=1;
        System.out.println(vehicle+" deletion successful!");
        System.out.println("No of available spaces: "+getSpaces());
        return true;
    }

    @Override
    public boolean listOfVehicle() {
        System.out.println(getVehicles());
        return true;
    }

    @Override
    public boolean save() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");
            bufferedWriter.newLine();
            bufferedWriter.write("------------------------------------------------------------------Vehicles------------------------------------------------------------------");
            bufferedWriter.newLine();
            bufferedWriter.write("");
            bufferedWriter.newLine();
            bufferedWriter.write("");
            bufferedWriter.newLine();
            for (int i = 0; i < getVehicles().size(); i++) {
                bufferedWriter.write((i+1)+") "+getVehicles().get(i));
                bufferedWriter.newLine();
                bufferedWriter.write("");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println("File upload crashed!");
        }
        System.out.println("Saved successfully!");
        return true;
    }

    @Override
    public boolean bookVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean checkAvailability(Vehicle vehicle) {
        return false;
    }

    @Override
    public void sortVehicles() {

    }

    @Override
    public void generateReport() {
        try {
            if(getVehicles().size()==0){
                System.out.println("No vehicles!. Therefore, none to be shown...");
            }else {
                Desktop desktop = Desktop.getDesktop();
                if (!Desktop.isDesktopSupported()) {
                    System.out.println("Not Supported!");
                }
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.out.println("File cannot be found!");
                }
            }
        }catch (Exception e){
            System.out.println("File opening failed!");
        }
    }

    public static int getSpaces() {
        return spaces;
    }

    public static void setSpaces(int spaces) {
        WestminsterRentalVehicleManager.spaces = spaces;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public static void setVehicles(List<Vehicle> vehicles) {
        WestminsterRentalVehicleManager.vehicles = vehicles;
    }


    public static List<Vehicle> getRDeletedVehicles() {
        return deletedVehicles;
    }

    public static void setDeletedVehicles(List<Vehicle> rentedVehicles) {
        WestminsterRentalVehicleManager.deletedVehicles = rentedVehicles;
    }

    public ArrayList<Car> getCars(){
        ArrayList<Car> carList = new ArrayList<>();
        MongoCollection<Document> cars = database.getCollection("Cars");
        for (Document row:cars.find()) {
            Car car = new Car(
                    (String) row.get("plateNumber"),
                    (String) row.get("make"),
                    (String) row.get("model"),
                    (String) row.get("color"),
                    (String) row.get("capacity"),
                    (String) row.get("transmission"),
                    (String) row.get("fuelType"),
                    (int) row.get("yearOfProduction"),
                    (int) row.get("noOfDoors"),
                    (int) row.get("noOfSeats"),
                    (String) row.get("hybridStatus")
            );
            carList.add(car);
        }
        return carList;
    }
    public ArrayList<Motorbike> getMotorbikes(){
        ArrayList<Motorbike> motorbikeList = new ArrayList<>();
        MongoCollection<Document> cars = database.getCollection("Motorbikes");
        for (Document row:cars.find()) {
            Motorbike motorbike = new Motorbike(
                    (String) row.get("plateNumber"),
                    (String) row.get("make"),
                    (String) row.get("model"),
                    (String) row.get("color"),
                    (String) row.get("capacity"),
                    (String) row.get("transmission"),
                    (String) row.get("fuelType"),
                    (int) row.get("yearOfProduction"),
                    (String) row.get("startType"),
                    (String) row.get("bikeType")
            );
            motorbikeList.add(motorbike);
        }
        return motorbikeList;
    }
    public ArrayList<Vehicle> getVehicle(){
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        MongoCollection<Document> vehicleDatabase = database.getCollection("Vehicles");
        for (Document row:vehicleDatabase.find()) {
            Vehicle vehicle = new Vehicle(
                    (String) row.get("plateNumber"),
                    (String) row.get("make"),
                    (String) row.get("model"),
                    (String) row.get("color"),
                    (String) row.get("capacity"),
                    (String) row.get("transmission"),
                    (String) row.get("fuelType"),
                    (int) row.get("yearOfProduction")
            );
            vehicleList.add(vehicle);
        }
        return vehicleList;
    }
}

class MakeComparator implements Comparator<Vehicle>{
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getMake().compareTo(o2.getMake());
    }
}
