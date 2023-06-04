import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.Upload;

public class TestThread {

    @ParameterizedTest
    @ValueSource(strings = {"1.jpg", "2.jpg", "3.jpg", "4.jpg"})
    void testThread( String imagePath ) {
        try {
            Upload upload = new Upload( imagePath );
            upload.start();
            upload.join();
        }catch (Exception ex) {
            Assertions.assertTrue(false, ex.toString());
        }
    }

}
