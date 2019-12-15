package com.example.demo.Repository;

import com.example.demo.Manager.Car;
import com.example.demo.Manager.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepo extends CrudRepository<Vehicle,String> {
}
