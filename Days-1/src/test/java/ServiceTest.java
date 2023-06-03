import models.User;
import models.users.Users;
import org.junit.jupiter.api.*;
import retrofit2.Response;
import services.IUser;
import utils.Api;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiceTest {

    IUser iUser;

    @BeforeAll
    public void beforeAll() {
        iUser = Api.client().create(IUser.class);
    }

    @Test
    @Order(1)
    public void userSaveTest() throws IOException {
        User u = new User();
        u.setFirstName("Erkan");
        u.setLastName("Bilmem");
        u.setEmail("erkan@mail.com");

        Response<User> userResponse = iUser.userSave(u).execute();
        User user = userResponse.body();
        System.out.println( user );
        Assertions.assertTrue( userResponse.isSuccessful(), "User Save Service Fail" );
        Assertions.assertTrue( user.getId() > 0, "User Save Fail" );
    }

    @Test
    @Order(2)
    public void userAllTest() throws IOException {
        Response<Users> usersResponse = iUser.users().execute();
        Users users = usersResponse.body();
        System.out.println( users );
        Assertions.assertAll(
                () -> Assertions.assertNotNull(users, "Service User Null Error"),
                () -> Assertions.assertTrue( users.getUsers().size() > 10, " Size 10 limit Error ")
        );
    }

}
