import models.Customer;
import org.junit.jupiter.api.*;
import services.CustomerService;
import utils.DB;

import java.sql.Connection;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DBTest {

    DB db;
    CustomerService customerService;

    @BeforeAll
    public void beforeAll() {
        db = new DB();
        customerService = new CustomerService();
    }

    @Test
    @Order(1)
    @DisplayName("DB Connect and Open Test")
    public void dbOpenTest() {
        Connection connection = db.conn();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(connection, "DB Connection Error Null"),
                () -> Assertions.assertTrue(!connection.isClosed(), "DB Open Error")
        );
    }

    @Test
    @Order(2)
    @DisplayName("DB Close Test")
    @Tag("security")
    public void dbCloseTest() {
        Assertions.assertTrue(db.close(), "DB Close Error");
    }

    @Test
    @Order(3)
    @DisplayName("Customer Save Test")
    @Tag("service")
    public void customerSaveTest() {
        Customer c = new Customer();
        c.setName("Ali Bilmem");
        c.setEmail("ali@mail.com");
        c.setPassword("12345");
        int status = customerService.save(c);
        Assertions.assertTrue( status > 0, "Customer Save Error");
    }

}
