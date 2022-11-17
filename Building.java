import java.time.Year;

public class Building {
    // Every building has the year of built and number of floors.
    // You must use the class Year, which is located in the java.time package, for
    // data type of instance variable year
    private Year yearBuilt;
    private int numberOfFloors;

    // Develop the default constructor which initializes the year of built to the
    // current year, and number of floors to 1.
    // Current year must not be hard coded by a constant value, like 2022.
    public Building() {
        this.yearBuilt = Year.now();
        this.numberOfFloors = 1;
    }

    // Develop another constructor with two parameters, the year of built and number
    // of floors, which initializes the corresponding instance variables.
    public Building(Year yearBuilt, int numberOfFloors) {
        this.yearBuilt = yearBuilt;
        this.numberOfFloors = numberOfFloors;
    }
}