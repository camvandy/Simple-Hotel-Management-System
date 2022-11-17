import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;

/**
 * This class is used to create a hotel object in which every Hotel is a
 * Building
 * which will inherits some extra features. This class will allow the user to
 * create
 * a hotel object and add rooms to it which will include actions on rooms.
 * 
 * @author Cameron Vandermeersch
 * @version 1.0
 */

public class Hotel extends Building {
    // Every hotel has Name, rate, one or more owners, and one or more rooms.
    private String hotelName;
    private double hotelRate;
    private ArrayList<Person> owners;
    private ArrayList<Room> rooms;

    /**
     * This is the default constructor for the class. It will initialize the
     * hotelName,
     * The constructor will call the default constructor of the superclass which
     * will initialize th buildingRate, and buildingYear.
     */
    public Hotel() {
        super();
    }

    /**
     * Overloaded constructor for the class that will initialize the hotelName,
     * owners, yearBuilt, numberOfFloors, and hotelRate. This will call the proper
     * constructor of the superclass must be called in this constructor. This will
     * allow the user to pass values to initialize for the hotel components.
     * 
     * @param name           will be the name of the hotel that will be assigned to
     *                       the hotelName instance variable.
     * @param owners         will be the owners of the hotel that will be assigned
     *                       to the owners instance variable.
     * @param yearBuilt      will be the year the hotel was built that will be
     *                       passed to the superclass constructor.
     * @param numberOfFloors will be the number of floors the hotel has that will be
     *                       passed to the superclass constructor.
     * @param rate           will be the rate given for the hotel that will be
     *                       assigned to the hotelRate instance variable.
     */
    public Hotel(String name, ArrayList<Person> owners, Year yearBuilt, int numberOfFloors, double rate) {
        super(yearBuilt, numberOfFloors);
        this.hotelName = name;
        this.owners = owners;
        this.hotelRate = rate;
        this.rooms = new ArrayList<Room>();
    }

    /**
     * This method will return the owners of the hotel.
     * 
     * @return owners which is the owners of the hotel.
     */
    public ArrayList<Person> getOwners() {
        return owners;
    }

    /**
     * This method will return the name of the hotel.
     * 
     * @return hotelName which is the the name of the hotel.
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * This method will return the rooms of the hotel. This will be the list of the
     * hotel rooms as an ArrayList of rooms.
     * 
     * @return rooms which is the rooms of the hotel.
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     * This method will return the room that is requested by the user.
     * This method will provide the user the corresponding room as its return type
     * and if this process is unsuccessful, it will return null not getting the
     * room.
     * 
     * @param roomNumber will be the room number that is wanted.
     * @return room which is the room that the user wants which will be the the
     *         corresponding room as its return type.
     */
    public Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    /**
     * This method will add one owner to the hotel’s owners list by adding the owner
     * to the owners list.
     * 
     * @param owner will be the owner that is being added to the hotel’s owners
     *              list.
     */
    public void addOwner(Person owner) {
        owners.add(owner);
    }

    /**
     * This method will add a room to the hotel’s rooms list by adding the room to
     * the rooms list.
     * 
     * @param room will be the room that is being added to the hotel’s rooms list.
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * This method will reserve a room for a guest by getting the room number, start
     * date, end date, and guest and will first find the room and will reserve the 
     * room if the room is found. If the room is not found or if the room is not 
     * available for the period specified, it returns zero, which means the reservation 
     * was not successful.
     * 
     * @param roomNumber will be the room number that is being reserved.
     * @param startDate  will be the start date of the reservation.
     * @param endDate    will be the end date of the reservation.
     * @param guest      will be the guest that is being reserved.
     * @return reservationNumber which is the reservation number of the reservation
     *         for the guest.
     */
    public int reserve(int roomNumber, Date startDate, Date endDate, Person guest) {
        Room room = getRoom(roomNumber);
        if (room != null) {
            return room.reserve(startDate, endDate, guest);
        }
        return 0;
    }

    /**
     * This method will cancel a reservation by getting the reservation number and
     * will first
     * find the room that has this reservation number. If it finds the room, then it
     * will call
     * the cancel method of that room with the reservation number given, and then
     * returns true.
     * Otherwise, it returns false, which means the cancellation was not successful.
     * 
     * @param reservationNumber will be the reservation number that is being
     *                          canceled.
     * @return boolean which is true if the cancellation was successful and false if
     *         it was not successful.
     */
    public boolean cancel(int reservationNumber) {
        // use getRoom
        Room room = getRoom(reservationNumber);
        if (room != null) {
            room.cancel(reservationNumber);
            return true;
        }
        return false;
    }

    /**
     * This method will return a string that includes the hotel information,
     * followed by the rooms’
     * information and the rooms details and description.
     * 
     * @return hotelInfo which is the hotel information that will be displayed
     */
    @Override
    public String toString() {
        String string = "";
        string += "Hotel " + this.hotelName + ", " + this.hotelRate + " stars." + "\n";
        string += "Hotel Owner: ";
        for (int i = 0; i < this.owners.size(); i++) {
            string += this.owners.get(i) + " ";
        }
        string += "\nRooms:\n";
        for (int i = 0; i < this.rooms.size(); i++) {
            string += this.rooms.get(i);
        }
        return string;
    }
}

// public int reserve(int roomNo, Date startDate, Date endDate, Person guest) {
// for (Room room : rooms) {
// if (room.getRoomNumber() == roomNo) {
// return room.reserve(startDate, endDate, guest);
// }
// }
// return 0;
// }
