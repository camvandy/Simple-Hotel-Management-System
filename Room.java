import java.sql.Date;
import java.util.ArrayList;

public class Room {
    // Define an enum, named RoomType, with the four possible values below: (2
    // marks)
    // SINGLE, DOUBLE, STUDIO, SUITE
    public enum RoomType {
        SINGLE, DOUBLE, STUDIO, SUITE
    }

    // Every room instance object has (8 marks)
    // Room type, price per night, room size, floor number, room number,
    // description, vacancy status, and an ArrayList of all its reservations
    private RoomType roomType;
    private double pricePerNight;
    private String description;
    private boolean vacancyStatus;
    private double roomSize;
    private int floorNumber;
    private int roomNumber;
    private ArrayList<Reservation> reservations;

    // Develop a constructor with six parameters, room type, price, size, room
    // number, floor, and description. Note that you must also initialize the
    // vacancy status and the empty list of reservations.
    public Room(RoomType roomType, double pricePerNight, int roomSize, int roomNumber, int floorNumber,
            String description) {
        this.roomType = roomType;
        this.floorNumber = floorNumber;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.roomSize = roomSize;
        this.roomNumber = roomNumber;
        vacancyStatus = true;
        reservations = new ArrayList<Reservation>();
    }

    // Develop getter methods for the vacancy status, room number, price, and list
    // of the reservations.
    public boolean getVacancyStatus() {
        return vacancyStatus;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    // Develop a setter method for the price.
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // Develop a method, reserve, which gets start date (inclusive), end date
    // (exclusive), and guest, and will reserve the room. Note that the room
    // availability should be checked in this method. If the room is available, then
    // it reserves the room and returns the reservation number, and otherwise
    // returns zero.
    public int reserve(Date startDate, Date endDate, Person guest) {
        if (this.vacancyStatus) {
            Reservation reservation = new Reservation(startDate, endDate, this.pricePerNight, guest);
            this.reservations.add(reservation);
            return reservation.getReservationNumber();
        } else {
            return 0;
        }
    }

    // Develop a method, cancel, that gets a reservation number and cancels it
    public void cancel(int reservationNumber) {
        for (Reservation reservationRoom : this.reservations) {
            if (reservationRoom.getReservationNumber() == reservationNumber) {
                this.reservations.remove(reservationRoom);
            }
        }
    }

    // Develop two methods, checkin and checkout, to set the vacancy type of the
    // room, accordingly.
    public void checkin() {
        this.vacancyStatus = true;
    }

    public void checkout() {
        this.vacancyStatus = false;
    }

    // Develop a method, status, which returns a string including the list of all
    // the reservations of the room
    // Reservation list of room number 102: Vacant.
    // Reservation Number: 10001
    // From: 2021-03-21 To: 2021-03-24
    // Guest: Joe Uncle
    // $50.5 per night
    public String status() {
        String status;
        if (this.vacancyStatus == true) {
            status = "Vacant";
        } else {
            status = "Occupied";
        }
        status = "Reservation list of room number " + this.roomNumber + ": " + status + ".";
        for (int hold = 0; hold < this.reservations.size(); hold++) {
            status = status + "\n" + this.reservations.get(hold);
        }
        return status;
    }

    // Override the toString method, such that it returns a string including the
    // room information, with the format like example below. The last part of the
    // following example is the room description. (2 marks)
    // SINGLE, price=$35.5, Size=200.0, Number=101, Floor=1
    // Description: Single Room without view
    @Override
    public String toString() {
        return this.roomType + ", price=$" + this.pricePerNight + ", Size=" + this.roomSize + ", Number="
                + this.roomNumber + ", Floor=" + this.floorNumber + "\nDescription: " + this.description + "\n";
    }
}


// public int reserve(Date startDate, Date endDate, Person guest) {
// if (isVacant) {
// reservations.add(new Reservation(startDate, endDate, price, guest));
// return roomNumber;
// }
// return 0;
// }
