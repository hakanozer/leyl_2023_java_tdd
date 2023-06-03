package models;

import lombok.Data;

@Data
public class Customer {

    private int cid;
    private String name;
    private String email;
    private String password;

}
