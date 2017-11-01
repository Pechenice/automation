
import controls.BaseControl;
import core.PropertiesContainer;
import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.List;

public class GitHubTest extends TestBase{

    @Test
    public void logIn() {
        StartPage startPage = new StartPage();
        startPage = startPage.goToLoginPage().logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        Assert.assertEquals(startPage.getTitleText(), "Learn Git and GitHub without any code!");
    }

    @Test
    public void createRepo() {
        StartPage startPage = new StartPage();
        startPage = startPage.goToLoginPage().logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        RepoCreationPage repoCreationPagePage = startPage.goToRepoCreation();
        RepoPage repoPage = repoCreationPagePage.createRepo(PropertiesContainer.get("test.repositoryName"));
        Assert.assertEquals(repoPage.getTitle(), "Quick setup");

        deleteRepo(repoPage);
    }

    @Test
    public void updateProfile() {
        StartPage startPage = new StartPage();
        startPage = startPage.goToLoginPage().logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
        EditProfilePage editProfilePage = startPage.goToProfilePage().goToEditProfilePage();
        ProfilePage profilePage = editProfilePage.upDateProfile().goToProfileAfterUpdate();
        List<BaseControl> listOfProfileInformation = profilePage.getProfileInformation();
        for (BaseControl info: listOfProfileInformation) {
            if (info.getText().equals(PropertiesContainer.get("test.profileName"))) {
                continue;
            } else if (info.getText().equals(PropertiesContainer.get("test.profileBio"))) {
                continue;
            } else if (info.getText().equals(PropertiesContainer.get("test.profileCompany"))) {
                continue;
            } else {
                Assert.fail(info + " is absent on user's profile page");
                break;
            }
        }
        //add here assert

        //delete all what was done
    }

    private void deleteRepo(RepoPage repoPage) {
        SettingsPage settingsPage = repoPage.goToSettings();
        settingsPage.deleteRepoButton().click();
        settingsPage.deleteRepo(PropertiesContainer.get("test.repositoryName"));
    }
}

// ProfilePage - not all of button are present always. May be make some check, that buttons are visible
// Somehow I need to compare text from items in list with those one, in properties. Problem - idk what item is inside