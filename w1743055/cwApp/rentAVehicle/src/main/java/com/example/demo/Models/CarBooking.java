package com.example.demo.Models;
import com.example.demo.Manager.Car;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;
@Document(collection = "Bookings")
public class CarBooking {
    public String plateNumber;
    public String email;
    public String nic;
    public Date pickUpDate;
    public Date dropOffDate;

    public CarBooking(String plateNumber, String email, String nic, Date pickUpDate, Date dropOffDate) {
        this.plateNumber = plateNumber;
        this.email = email;
        this.nic = nic;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public CarBooking(Car car, CarBooking carBooking) {
    }

    public CarBooking() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return plateNumber.equals(that.plateNumber) &&
                email.equals(that.email) &&
                nic.equals(that.nic) &&
                pickUpDate.equals(that.pickUpDate) &&
                dropOffDate.equals(that.dropOffDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, email, nic, pickUpDate, dropOffDate);
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "plateNumber='" + plateNumber + '\'' +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}
