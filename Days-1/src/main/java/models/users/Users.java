package models.users;

import java.util.List;

@lombok.Data
public class Users {
    private List<User> users;
    private Long total;
    private Long skip;
    private Long limit;
}
