import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import services.IUser;
import utils.Api;

import java.io.IOException;

public class ServiceTest {

    @Test
    public void userSaveTest() throws IOException {
        User u = new User();
        u.setFirstName("Erkan");
        u.setLastName("Bilmem");
        u.setEmail("erkan@mail.com");

        IUser iUser = Api.client().create(IUser.class);
        Response<User> userResponse = iUser.userSave(u).execute();
        User user = userResponse.body();
        System.out.println( user );
        Assertions.assertTrue( userResponse.isSuccessful(), "User Save Service Fail" );
        Assertions.assertTrue( user.getId() > 0, "User Save Fail" );
    }

}
