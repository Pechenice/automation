import core.Driver;
import core.PropertiesContainer;
import core.TestBase;
import org.testng.annotations.Test;
import pages.PikabuHomePage;

public class GoToTest {
    @Test
    public static void goTo() {
//        Driver.get().get(System.getProperty("test.baseUrl"));
//        System.out.println("Base Url is loaded");
        PropertiesContainer.get("test.timeouts");
    }

//    @Test
//    public static void enterSite() {
//        Driver.get().get(System.getProperty("test.baseUrl"));
//        PikabuHomePage homePage = new PikabuHomePage();
//        homePage.login("something", "pass12345");
//    }
}
