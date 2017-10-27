import core.PropertiesContainer;
import core.TestBase;
import org.testng.annotations.Test;
import pages.PikabuHomePage;

public class PikabuHomeTest extends TestBase {

    @Test
    public static void enterSite() {
        PikabuHomePage homePage = new PikabuHomePage();
        homePage.login(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
    }
}
