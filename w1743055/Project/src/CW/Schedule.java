package CW;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    protected LocalDate bookDate;
    protected LocalTime time;
    protected Date pickUpDate;
    protected Date dropOffDate;

    public Schedule(LocalDate bookDate, LocalTime time) {
        this.bookDate = bookDate;
        this.time = time;
    }

    public Schedule(Date pickUpDate, Date dropOffDate) {
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDate bookDate) {
        this.bookDate = bookDate;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }
}
