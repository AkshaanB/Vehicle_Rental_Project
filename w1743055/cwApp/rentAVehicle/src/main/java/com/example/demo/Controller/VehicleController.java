package com.example.demo.Controller;

import com.example.demo.Manager.Car;
import com.example.demo.Manager.Motorbike;
import com.example.demo.Manager.Vehicle;
import com.example.demo.Manager.WestminsterRentalVehicleManager;
import com.example.demo.Models.CarBooking;
import com.example.demo.Repository.CarRepo;
import com.example.demo.Repository.MotorbikeRepo;
import com.example.demo.Service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
//    //Creating Mongo Client
//    MongoClient mongoClient = new MongoClient("localhost",27017);
//
//    //Creating credentials
//    MongoCredential credential = MongoCredential.createCredential("Akshaan","VehicleDatabase","akshaan123456".toCharArray());
//
//
//    //Accessing Database
//    MongoDatabase database = mongoClient.getDatabase("VehicleDatabase"); //creates the database
//
//
//
//    MongoCollection<Document> collection = database.getCollection("Bookings");
//    MongoCollection<Document> cars = database.getCollection("Cars");

    WestminsterRentalVehicleManager manager = new WestminsterRentalVehicleManager();

    @Autowired
    CarRepo carRepo;

    @Autowired
    MotorbikeRepo motorbikeRepo;

    @Autowired
    CarService carService;


//    @GetMapping("/vehicles")
//    public List<Vehicle> getVehicles(){
//        return vehicleRepo.findAll();
//    }

    @RequestMapping("/hi")
    public String getMessage(){
        return "Hi!";
    }

    @CrossOrigin(origins = "http://localhost:4400")
    @RequestMapping(value = "/cars",method = RequestMethod.GET,produces = "application/json")
    public List<Car> getCars(){
        return manager.getCars();
    }

    @CrossOrigin(origins = "http://localhost:4400")
    @RequestMapping(value = "/motorbikes", method = RequestMethod.GET,produces = "application/json")
    public List<Motorbike> getMotorbike(){
        return manager.getMotorbikes();
    }

    @CrossOrigin(origins = "http://localhost:4400")
    @RequestMapping(value = "/vehicles", method = RequestMethod.GET,produces = "application/json")
    public List<Vehicle> getVehicles(){
        return manager.getVehicle();
    }

//    @CrossOrigin(origins = "http://localhost:4400")
//    @RequestMapping(value = "/cars/{plateNumber}",method = RequestMethod.GET,produces = "application/json")
//    public Car getCarsOnPlateNumber(@PathVariable String plateNumber){
//        for (Car car: manager.getCars()) {
//            if(car.getPlateNumber().equalsIgnoreCase(plateNumber)){
//                return car;
//            }
//        }
//        return null;
//    }
//
//    @CrossOrigin(origins = "http://localhost:4400")
//    @RequestMapping(value = "/motorbikes/{plateNumber}",method = RequestMethod.GET,produces = "application/json")
//    public Motorbike getMotorbikeOnPlateNumber(@PathVariable String plateNumber){
//        for (Motorbike motorbike: manager.getMotorbikes()) {
//            if(motorbike.getPlateNumber().equalsIgnoreCase(plateNumber)){
//                return motorbike;
//            }
//        }
//        return null;
//    }

//    @CrossOrigin(origins = "http://localhost:4400")
//    @RequestMapping(value = "/bookingcar/{car}/{email}/{nic}",method = RequestMethod.POST,produces = "application/json")
//    public String bookCar(@PathVariable Car car, @PathVariable String email, @PathVariable String nic, @RequestParam Date pickup, @RequestParam Date dropoff){
//        CarBooking carBooking = carService.createCarBooking(car,email,nic,pickup,dropoff);
//        return carBooking.toString();
//    }
//    @RequestMapping(value = "/bookingmotorbike/{motorbike}/{email}/{nic}",method = RequestMethod.POST,produces = "application/json")
//    public void bookMotorbike(@PathVariable Motorbike motorbike,@PathVariable String email,@PathVariable String nic,@RequestParam Date pickup,@RequestParam Date dropoff){
//
//    }

    @RequestMapping(value = "/value",method = RequestMethod.GET,produces = "application/json")
    public String car(){
        return "{message}:datapassed";
    }

    @CrossOrigin(origins = "http://localhost:4400")
    @RequestMapping(value = "/bookingcar", method = RequestMethod.POST,produces = "application/json")
    public String bookCar(@RequestBody CarBooking carBooking) throws JsonProcessingException {
        Car car = getCar(carBooking.plateNumber);
//        Document document1 = new Document();
//        document1.append("car", car);
//        document1.append("car booking", carBooking);
//        MongoCollection<Document> collection = database.getCollection("Bookings");
//        collection.insertOne(document1);
        CarBooking carBooking1 = carService.createBooking(carBooking.plateNumber,carBooking.email,carBooking.nic,carBooking.pickUpDate,carBooking.dropOffDate);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(carBooking1);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:4400")
    @RequestMapping(value = "/bookingmotorbikes", method = RequestMethod.POST,produces = "application/json")
    public void bookMotorbike(){

    }

    public Car getCar(String plateNumber){
        for (Car car: manager.getCars()) {
            if(car.getPlateNumber().equalsIgnoreCase(plateNumber)){
                return car;
            }
        }
        return null;
    }

    public Motorbike getMotorbike(String plateNumber){
        for (Motorbike motorbike: manager.getMotorbikes()) {
            if(motorbike.getPlateNumber().equalsIgnoreCase(plateNumber)){
                return motorbike;
            }
        }
        return null;
    }
}
