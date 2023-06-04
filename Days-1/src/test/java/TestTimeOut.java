import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTimeOut {

    @Test
    void timeTest_1() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(11);
        System.out.println("timeTest_1 Call");
    }

    @Test
    void timeTest_2() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5);
        System.out.println("timeTest_2 Call");
    }


    @Test
    void timeTest_3() {
        Assertions.assertTimeout(Duration.ofMillis(5), () -> {
            getVal();
        });
    }

    String getVal() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(6);
        return "getValue";
    }

    @RepeatedTest(5)
    @Tag("service")
    void repeatTest() {
        System.out.println( "repeatTest Call" );
    }

    @Disabled
    @Test
    void ignoreTest() {
        System.out.println("ignoreTest Call");
    }


    @Test
    @EnabledIf("customSecurity")
    @DisplayName("Token Disable JWT")
    void disableIf() {
        System.out.println("Token Disable JWT Call");
    }

    boolean customSecurity() {
        return true;
    }

    // OS
    // Mac
    @Test
    @EnabledOnOs(OS.MAC)
    void enableOnMac() {
        System.out.println("Mac OSX Call ");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void enableOnWindows() {
        System.out.println("Windows OS Call ");
    }


    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void enableOnJre_8() {
        System.out.println("JAVA_8 Call");
    }


    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_10)
    void enableOnRangeJre_8_10() {
        System.out.println("JAVA_8 - JAVA_10 Call");
    }

}
