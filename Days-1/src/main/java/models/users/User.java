package models.users;

import java.time.LocalDate;

@lombok.Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private Long age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;
    private String image;
    private String bloodGroup;
    private Long height;
    private Double weight;
    private String eyeColor;
    private Hair hair;
    private String domain;
    private String ip;
    private Address address;
    private String macAddress;
    private String university;
    private Bank bank;
    private Company company;
    private String ein;
    private String ssn;
    private String userAgent;
}
