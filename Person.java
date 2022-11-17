public class Person {
    // Every person has first and last names.
    private String firstName;
    private String lastName;

    // Develop a constructor that gets two parameters, first and last names, and
    // initializes the corresponding instance variables.
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Override the toString method, such that it returns first and last names with
    // one space in between.
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}