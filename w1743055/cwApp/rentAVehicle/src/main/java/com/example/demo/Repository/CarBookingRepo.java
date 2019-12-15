package com.example.demo.Repository;

import com.example.demo.Models.CarBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarBookingRepo extends MongoRepository<CarBooking,String> {
    public CarBooking findByNic(String nic);
    public List<CarBooking> findByEmail(String email);
}
