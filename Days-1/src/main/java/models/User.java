package models;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;

}
