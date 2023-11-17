package domain;

public class Name {
    private String firstName;
    private String lastName;

    public static Name name(String firstName, String lastName) {
        return new Name(firstName, lastName);
    }

    private Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}