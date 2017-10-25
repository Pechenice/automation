import core.Driver;
import core.TestBase;
import org.testng.annotations.Test;
import pages.PikabuHomePage;

public class GoToTest extends TestBase {
    @Test
    public static void goTo() {
        Driver.get().get(System.getProperty("test.baseUrl"));
        System.out.println("Base Url is loaded");
    }

    @Test
    public static void enterSite() {
        Driver.get().get(System.getProperty("test.baseUrl"));
        PikabuHomePage.login("something", "pass12345");
    }
}
