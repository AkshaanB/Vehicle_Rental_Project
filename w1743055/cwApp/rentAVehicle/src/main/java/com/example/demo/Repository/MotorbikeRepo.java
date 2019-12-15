package com.example.demo.Repository;

import com.example.demo.Manager.Motorbike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorbikeRepo extends MongoRepository<Motorbike,String> {
}
