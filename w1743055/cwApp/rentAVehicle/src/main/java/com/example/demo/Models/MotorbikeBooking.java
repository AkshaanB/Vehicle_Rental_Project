package com.example.demo.Models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document(collection = "Bookings")
public class MotorbikeBooking {
    public String plateNumber;
    public String email;
    public String nic;
    public Date pickUpDate;
    public Date dropOffDate;

    public MotorbikeBooking() {
    }

    public MotorbikeBooking(String plateNumber, String email, String nic, Date pickUpDate, Date dropOffDate) {
        this.plateNumber = plateNumber;
        this.email = email;
        this.nic = nic;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotorbikeBooking that = (MotorbikeBooking) o;
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
        return "MotorbikeBooking{" +
                "plateNumber='" + plateNumber + '\'' +
                ", email='" + email + '\'' +
                ", nic='" + nic + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                '}';
    }
}
