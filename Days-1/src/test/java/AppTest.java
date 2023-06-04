import org.junit.jupiter.api.*;
import utils.Action;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppTest {

    Action action;
    Random random;

    public AppTest() {
        System.out.println("AppTest Call");
    }

    // Bütün testlerden önce bir kez çalış
    @BeforeAll
    public void beforeAll() {
        action = new Action();
        System.out.println("BeforeAll Call");
    }

    // Her test methodundan önce çalışır
    @BeforeEach
    public void beforeEach() {
        System.out.println("BeforeEach Call");
        random = new Random();
    }

    @Order(1)
    @Test
    @DisplayName("User Eft BDDK Control")
    @Tag("security")
    public void bddkTest() {
        System.out.println("bddk Call");
    }

    @Order(4)
    @Test
    @DisplayName("User Eft Total Control")
    public void userTotalTest() {
        System.out.println("userTotalTest Call");
    }

    @Order(2)
    @Test
    @DisplayName("Size 9 char Control")
    @Tag("security")
    public void test_1() {
        System.out.println( action.hashCode() );
        int size = action.size("Java Test");
        //Assertions.assertTrue( size > 10, "Data Size Error!" );
        Assertions.assertEquals(8, size, "Data Size Error!");
    }

    @Order(3)
    @Test
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 2000)
    public void test_2() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(2010);
        System.out.println( action.hashCode() );
        Assertions.assertEquals(9, 9, "Data Size Error!");
    }

    @Order(5)
    @Test
    public void test_3() {
        System.out.println( action.hashCode() );
        Assertions.assertEquals(9, 9, "Data Size Error!");
    }



    @AfterEach
    public void afterEach() {
        System.out.println("AfterEach Call");
        random = null;
    }

    // Tüm test methodlarından sonra bir kez çalışır
    @AfterAll
    public void afterAll() {
        System.out.println("AfterAll Call");
        action = null;
    }


}

/*

BBDK -> kullanıcı doğrula
banka hesap total
karşı taraf
eft başlat

 */