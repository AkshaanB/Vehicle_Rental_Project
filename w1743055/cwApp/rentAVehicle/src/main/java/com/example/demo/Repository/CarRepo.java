package com.example.demo.Repository;

import com.example.demo.Manager.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends MongoRepository<Car,String> {
}
