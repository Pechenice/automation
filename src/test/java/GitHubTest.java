
import core.Driver;
import core.PropertiesContainer;
import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RepoCreationPage;
import pages.RepoPage;
import pages.SettingsPage;
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
        StartPage startPage = new StartPage();
        startPage = startPage.goToLoginPage().logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        RepoCreationPage repoCreationPagePage = startPage.goToRepoCreation();
        RepoPage repoPage = repoCreationPagePage.createRepo(PropertiesContainer.get("test.repositoryName"));
        Assert.assertEquals(repoPage.getTitle(), "Quick setup");

        deleteRepo(repoPage);
    }

    private void deleteRepo(RepoPage repoPage) {
        SettingsPage settingsPage = repoPage.goToSettings();
        settingsPage.deleteRepoButton().click();
        settingsPage.deleteRepo(PropertiesContainer.get("test.repositoryName"));
    }
}
