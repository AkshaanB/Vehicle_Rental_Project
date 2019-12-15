package CW;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    private static WestminsterRentalVehicleManager manager = new WestminsterRentalVehicleManager();
    private static Scanner input = new Scanner(System.in);
    private static Scanner input1 = new Scanner(System.in);
    private static Scanner input2 = new Scanner(System.in);
    public static void main(String[] args) {
        //Creating Mongo Client
        MongoClient mongoClient = new MongoClient("localhost",27017);

        //Creating credentials
        MongoCredential credential = MongoCredential.createCredential("Akshaan","VehicleDatabase","akshaan123456".toCharArray());

        System.out.println("Connected to Database successfully");

        //Accessing Database
        MongoDatabase database = mongoClient.getDatabase("VehicleDatabase"); //creates the database

        System.out.println("Credentials ::"+ credential);

        //database.createCollection("Vehicles");

        System.out.println("Connection created successfully");

        MongoCollection<Document> collectionVehicles = database.getCollection("Vehicles"); //creates the collection Vehicles
        MongoCollection<Document> collection1 = database.getCollection("Cars");  //creates the collection Car
        MongoCollection<Document> collection2 = database.getCollection("Motorbikes"); //creates the collection Motorbikes

        System.out.println("Collection selected successfully");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println("~~~~~ Accessing on "+ localDate+" at "+localTime+" ~~~~~");

        System.out.println("Select option:");
        System.out.println("  1) Add Vehicle");
        System.out.println("  2) Delete Vehicle");
        System.out.println("  3) Print List of items");
        System.out.println("  4) Save");
        System.out.println("  5) Generate Report of the recent changes");
        System.out.println("  6) Search Vehicle");
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
                        String plateNumber = input1.nextLine();
                        while (!(plateNumber.length()==8 || plateNumber.length()==7|| plateNumber.length()==6)){
                            System.err.println("Invalid plate number!");
                            System.out.print("Please renter: ");
                            plateNumber = input1.nextLine();
                        }
                        System.out.print("Make: ");
                        String make = input2.next();
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
                        while (!((hybridStatus.equalsIgnoreCase("hybrid")|| (hybridStatus.equalsIgnoreCase("nonhybrid"))))){
                            System.err.println("Invalid input!");
                            System.out.print("Please renter: ");
                            hybridStatus = input1.next();
                        }
                        Document document1 = new Document();
                        document1.append("plateNumber", plateNumber);
                        document1.append("make", make);
                        document1.append("model", model);
                        document1.append("color", color);
                        document1.append("capacity", capacity);
                        document1.append("transmission", transmission);
                        document1.append("fuelType", fuelType);
                        document1.append("yearOfProduction",yearOfProduction);
                        document1.append("noOfDoors",noOfDoors);
                        document1.append("noOfSeats",noOfSeats);
                        document1.append("hybridStatus",hybridStatus);
                        collection1.insertOne(document1); //adds items to the mongodb database
                        collectionVehicles.insertOne(document1);
                        Vehicle vehicle = new Car(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction, noOfDoors,noOfSeats, hybridStatus);
                        manager.addVehicle(vehicle);
                    } else {
                        System.out.print("Plate number: ");
                        String plateNumber = input1.nextLine();
                        while (!(plateNumber.length()==8 || plateNumber.length()==7|| plateNumber.length()==6)){
                            System.err.println("Invalid plateNumber!");
                            System.out.print("Please renter: ");
                            plateNumber = input1.nextLine();
                        }
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
                        Document document2 = new Document();
                        document2.append("plateNumber", plateNumber);
                        document2.append("make", make);
                        document2.append("model", model);
                        document2.append("color", color);
                        document2.append("capacity", capacity);
                        document2.append("transmission", transmission);
                        document2.append("fuelType", fuelType);
                        document2.append("yearOfProduction",yearOfProduction);
                        document2.append("startType",startType);
                        document2.append("bikeType",bikeType);
                        collection2.insertOne(document2); //adds items to the mongodb database
                        collectionVehicles.insertOne(document2);
                        Vehicle vehicle = new Motorbike(plateNumber, make, model, color, capacity, transmission, fuelType, yearOfProduction, startType, bikeType);
                        manager.addVehicle(vehicle);
                    }
                    break;
                case 2:
                    System.out.print("Enter plate number: ");
                    String plateNumber = input2.nextLine();
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
                    collectionVehicles.deleteOne(Filters.eq("plateNumber",plateNumber));
                    collection1.deleteOne(Filters.eq("plateNumber",plateNumber));
                    collection2.deleteOne(Filters.eq("plateNumber",plateNumber));
                    break;
                case 3:
                    if(manager.getVehicles().size()==0){
                        System.out.println("---No Vehicles!---");
                    }else {
                        System.out.println("-----Vehicles-----");
                        System.out.println("----------Recently added----------"); //prints recently added vehicles
                        manager.getVehicles().sort(new MakeComparator());
                        for (Vehicle vehicle : manager.getVehicles()) {
                            System.out.println(vehicle);
                        }
                    }
                    System.out.println("--------------------------------------------");
                    System.out.println("--------------All the Vehicles--------------"); //prints all the vehicles
                    Document query1 = new Document();
                    List<Document> list1 = (List<Document>) collectionVehicles.find(query1).into(
                            new ArrayList<Document>());
                    for (Document doc:list1) {
                        System.out.println(doc);
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
                        URI uri = new URI("http://localhost:4400/search"); //inside paranthesis is the url which it needs to be directed
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
                    System.out.println("  6) Search Vehicle");
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
            System.out.println("  5) Generate Report of the recent changes");
            System.out.println("  6) Search Vehicle or View Vehicle/s");
            System.out.println("  7) Exit");
            System.out.print("Enter option: ");
            option = getInteger(input);
        }
    }
    private static int getInteger(Scanner input){ //this method validates whether the input is an int or not
        while (!input.hasNextInt()){
            System.err.println("Invalid input!");
            System.out.print("Please reenter: ");
            input.next();
        }
        return input.nextInt();
    }
}
