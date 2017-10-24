import core.Driver;
import core.TestBase;
import org.testng.annotations.Test;

public class GoToTest extends TestBase {
    @Test
    public static void goTo() {
        Driver.get().get(System.getProperty("test.baseUrl"));
        System.out.println("Base Url is loaded");
    }
}
