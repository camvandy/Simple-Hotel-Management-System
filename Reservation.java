import java.sql.Date;

public class Reservation {
    // Every reservation instance object has start date and end date
    private Date startDate;
    private Date endDate;
    // price per night
    private double pricePerNight;
    // guest (Note: Type of this instance variable should be Person)
    private Person guest;
    // reservation number
    private static int reservationNumber = 100000;

    // Develop a constructor with four parameters, start date, end date, price, and
    // guest. (1 mark)
    // (Note: You must set the reservation number for the reservation in this
    // constructor as well.
    public Reservation(Date startDate, Date endDate, double pricePerNight, Person guest) {
        this.startDate = startDate;
        this.pricePerNight = pricePerNight;
        this.guest = guest;
        this.endDate = endDate;
        reservationNumber++;
    }

    // Develop getter methods for the start date, end date and the reservation
    // number. (3 marks)
    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    // Develop a method, isAvailable, which gets start date (inclusive) and end date
    // (exclusive) and will check if the room is available during these dates or
    // not.
    public boolean isAvailable(Date startDate, Date endDate) {
        if (this.startDate.compareTo(startDate) <= 0 && this.endDate.compareTo(endDate) > 0) {
            return false;
        } else {
            return true;
        }
    }

    // Override the toString method, such that it returns a string including the
    // reservation number, start and end dates, guest, and price, with the format
    // like example below. (2 marks)
    @Override
    public String toString() {
        return "Reservation Number: " + reservationNumber + "\n" + "From: " + startDate + "\n" + "To: " + endDate + "\n"
                + "Guest: " + guest + "\n" + "$" + pricePerNight + " per night";
    }
}
