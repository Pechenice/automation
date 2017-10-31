
import core.PropertiesContainer;
import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StartPage;

public class GitHubTest extends TestBase{

    @Test
    public void logIn() {
        StartPage startPage = new StartPage();
        startPage = startPage.goToLoginPage().logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        Assert.assertEquals(startPage.getTitleText(), "Learn Git and GitHub without any code!");
    }

    @Test
    public void giveAccessToRepo() {

    }
}
