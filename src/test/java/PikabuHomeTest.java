import core.Driver;
import core.PropertiesContainer;
import core.TestBase;
import org.testng.annotations.Test;
import pages.PikabuHomePage;

public class PikabuHomeTest extends TestBase {

    @Test
    public static void goTo() {
        Driver.get().get(PropertiesContainer.get("test.baseUrl"));
        System.out.println("Base Url is loaded");
    }

    @Test
    public static void enterSite() {
        Driver.get().get(PropertiesContainer.get("test.baseUrl"));
        PikabuHomePage homePage = new PikabuHomePage();
        homePage.login("something", "pass12345");
    }
}
