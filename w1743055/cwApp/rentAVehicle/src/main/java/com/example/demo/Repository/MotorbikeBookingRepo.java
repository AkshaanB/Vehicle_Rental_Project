package com.example.demo.Repository;


import com.example.demo.Models.MotorbikeBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorbikeBookingRepo extends MongoRepository<MotorbikeBooking,String> {
    public MotorbikeBooking findByNic(String nic);
    public List<MotorbikeBooking> findByEmail(String email);
}
