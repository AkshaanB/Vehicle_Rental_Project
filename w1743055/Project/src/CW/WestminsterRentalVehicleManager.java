package CW;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WestminsterRentalVehicleManager implements RentalVehicleManager{
    final int PARKINGLOTS = 50; //there are exactly 50 spaces for vehicles
    public static int spaces = 50; //spaces is the current no of spaces remain initially starting from 50
    public static List<Vehicle> vehicles = new ArrayList<>(); //vehicles that are added contains in this list
    public static List<Vehicle> deletedVehicles = new ArrayList<>(); //vehicles that are deleted contains in this list
    private static File file = new File("Vehicles.txt"); //inside paranthesis is the name of the file

    @Override
    public boolean addVehicle(Vehicle vehicle){
        if (vehicles.size()<PARKINGLOTS) {
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
}

class MakeComparator implements Comparator<Vehicle>{ //compares Vehicles according to the make
    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getMake().compareTo(o2.getMake());
    }
}
