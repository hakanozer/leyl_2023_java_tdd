package models.users;

@lombok.Data
public class Address {
    private String address;
    private String city;
    private Coordinates coordinates;
    private String postalCode;
    private String state;
}
