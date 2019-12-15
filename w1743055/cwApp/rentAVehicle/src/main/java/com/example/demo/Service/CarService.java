package com.example.demo.Service;

import com.example.demo.Manager.Car;
import com.example.demo.Models.CarBooking;
import com.example.demo.Repository.CarBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarBookingRepo carBookingRepo;

//    public CarBooking createCarBooking(Car car, String email, String nic, Date pickUp, Date dropOff){
//        return carBookingRepo.save(new CarBooking(car,email,nic,pickUp,dropOff));
//    }

    public CarBooking createBooking(String plateNumber,String email, String nic, Date pickUp, Date dropOff){
        return carBookingRepo.save(new CarBooking(plateNumber,email,nic,pickUp,dropOff));
    }

    public List<CarBooking> getAllCarBooking(){
       return carBookingRepo.findAll();
    }
}
