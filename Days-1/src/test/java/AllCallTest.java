import org.junit.jupiter.api.DisplayName;
import org.junit.platform.suite.api.*;

@Suite
//@SelectClasses({AppTest.class, DBTest.class, ServiceTest.class})
@SelectPackages({""})
//@IncludeTags("security")
//@ExcludeTags("service")
//@IncludeClassNamePatterns({"^.*File.*"})
@DisplayName("All Test Display Name")
public class AllCallTest {
}
