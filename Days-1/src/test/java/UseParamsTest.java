import models.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import retrofit2.Call;
import retrofit2.Response;
import services.IUser;
import utils.Api;
import utils.EUserType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UseParamsTest {

    IUser iUser;

    @BeforeAll
    void beforeAll() {
        iUser = Api.client().create(IUser.class);
    }

    @ParameterizedTest
    @ValueSource( strings = { "İstanbul", "", "Ankara", "Bursa", "İzmir" } )
    @Tag("security")
    void testSTringValues( String item ) {
        Assertions.assertTrue( !item.isEmpty(), "String item Empty Error" );
    }

    @ParameterizedTest
    @EnumSource(EUserType.class)
    @Tag("service")
    void textEnumKeys( EUserType type ) {
        Object name = hmResult().get(type);
        Assertions.assertNotNull(name, "Name Null Error");
    }

    Map<EUserType, Object> hmResult() {
        Map<EUserType, Object> hm = new HashMap<>();
        hm.put(EUserType.standart, "Ali Bilmem");
        hm.put(EUserType.silver, "Mehmet Bilsin");
        hm.put(EUserType.gold, "Zehra Bilki");
        return hm;
    }

    @ParameterizedTest
    @MethodSource("users")
    void usersService(User user) throws IOException {
        Call<User> saveUser = iUser.userSave(user);
        Response<User> response = saveUser.execute();
        Assertions.assertAll(
                () -> Assertions.assertTrue(response.isSuccessful(), "Service Error"),
                () -> Assertions.assertTrue( response.body().getId() > 0, "ID Error" )
        );
    }

    static List<User> users() {
        List<User> ls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setLastName("User -" +i);
            u.setEmail("mail@mail.com - " + i);
            ls.add(u);
        }
        return ls;
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/data.csv", numLinesToSkip = 0)
    void csvReadd( String title, String detail, String category, int price  ) {
        System.out.println( title + " - " + detail + " - " + category + " - " + price );
    }


}
