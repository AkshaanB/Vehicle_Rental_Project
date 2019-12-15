package com.example.demo.Service;

import com.example.demo.Manager.Motorbike;
import com.example.demo.Models.MotorbikeBooking;
import com.example.demo.Repository.MotorbikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MotorbikeService {
    @Autowired
    private MotorbikeRepo motorbikeRepo;

//    public MotorbikeBooking createMotorbikeBooking(Motorbike motorbike,String email,String nic, Date pickUp, Date dropOff){
//        return motorbikeRepo.save(new MotorbikeBooking(motorbike,email,nic,pickUp,dropOff));
//    }
}
