import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {
        // Create a 3.5 stars hotel, named "Baba-Mama", built in 2018, with two floors
        // The owners' "firstname last name"'s of the hotel are "Ali Baba" and "Alice
        // Mama".

        Hotel hotel = new Hotel("Baba-Mama", new ArrayList<Person>(), Year.of(2018), 2, 3.5);
        hotel.addOwner(new Person("Ali Baba", "Mama"));
        hotel.addOwner(new Person("Alice", "Mama"));

        // Adding some rooms to this new hotel
        // SINGLE, price=$35.50, size=200, floor=1, number=101, description="Single Room
        // without view");
        hotel.addRoom(new Room(Room.RoomType.SINGLE, 35.50, 200, 101, 1, "Single Room without view"));

        // Double, price=$50.50, size=350, floor=1, number=102, description="Double Room
        // without view");
        hotel.addRoom(new Room(Room.RoomType.DOUBLE, 50.50, 350, 102, 1, "Double Room without view"));

        // Double, price=$55.00, size=400, floor=2, number=201, description="Double Room
        // with view");
        hotel.addRoom(new Room(Room.RoomType.DOUBLE, 55.00, 400, 201, 2, "Double Room with view"));

        // Suite, price=80.00, size=500, floor=2, number=202, description="Suite Room
        // with view and balcony");
        hotel.addRoom(new Room(Room.RoomType.SUITE, 80.00, 500, 202, 2, "Suite Room with view and balcony"));

        // Show the hotel information, including its rooms
        System.out.println(hotel);

        // Make reservations for the hotel for room 102 and Reservation number: 10001

        // Reserve the room number 102 for "Joe Uncle", check-in March 6, 2021, checkout
        // March 8, 2021. Print out the reservation result
        int roomNumber = 101;
        Date startDate = Date.valueOf("2021-05-25");
        Date endDate = Date.valueOf("2021-05-28");
        Person guest = new Person("Joe", "Uncle");
        int reservationNumber = hotel.reserve(roomNumber, startDate, endDate, guest);

        // Change the price of the room 102 to $52.00
        hotel.getRoom(roomNumber).setPricePerNight(52.00);

        // Reserve the room number 102 for "Mike Brother", checkin April 2, 2021,
        // checkout April 4, 2021
        // Print out the reservation result
        roomNumber = 102;
        startDate = Date.valueOf("2021-04-02");
        endDate = Date.valueOf("2021-04-04");
        guest = new Person("Mike", "Brother");
        reservationNumber = hotel.reserve(roomNumber, startDate, endDate, guest);

        // Reserve the room number 101 for "Maria Aunt", checkin May 27, 2021, checkout
        // May 28, 2021
        // Print out the reservation result
        roomNumber = 101;
        startDate = Date.valueOf("2021-05-27");
        endDate = Date.valueOf("2021-05-28");
        guest = new Person("Maria", "Aunt");
        reservationNumber = hotel.reserve(roomNumber, startDate, endDate, guest);

        // Reserve the room number 101 for "laura Sister", checkin May 25, 2021,
        // checkout May 28, 2021
        // Print out the reservation result
        roomNumber = 101;
        startDate = Date.valueOf("2021-05-25");
        endDate = Date.valueOf("2021-05-28");
        guest = new Person("laura", "Sister");
        reservationNumber = hotel.reserve(roomNumber, startDate, endDate, guest);

        // Check in the room 102.
        hotel.getRoom(102).checkin();
        System.out.println("Room 102 is checked in.");

        // Cancel reservation number 10003 and show the cancellation result.
        hotel.cancel(10003);
        System.out.println("Reservation 10003 is canceled.");

        // Show all the statuses of all the rooms
        System.out.println("---------------");
        System.out.println("Rooms' Statuses");
        System.out.println("---------------");
        // for loop with room.status().
        for (Room room : hotel.getRooms()) {
            System.out.println(room.status());
        }
    }
}