import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFile {

    @TempDir
    Path tempDir;

    @BeforeEach
    void beforeAll() throws IOException {
        Path temp = tempDir.resolve("test.txt");
        List<String> lines = Arrays.asList("İstanbul", "Ankara", "İzmir");
        Files.write(temp, lines);
    }

    @Test
    void fileExistsTest () throws IOException {
        Path temp = tempDir.resolve("test.txt");
        Assertions.assertTrue( Files.exists(temp), "Temp File Fail" );
        List<String> ls = Files.readAllLines(temp);
        Assertions.assertTrue( ls.get(0).equals("İstanbul"), "İstanbul Error" );
    }

}
