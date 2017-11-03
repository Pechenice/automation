
import controls.BaseControl;
import core.PropertiesContainer;
import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GitHubTest extends TestBase{

    public StartLoggedPage logIn() {
        StartUnloggedPage startUnloggedPagePage = new StartUnloggedPage();
        return startUnloggedPagePage.goToLoginPage().logIn(PropertiesContainer.get("test.login"), PropertiesContainer.get("test.password"));
    }

    @Test
    public void logInTest() {
        StartLoggedPage startLoggedPage = logIn();
        Assert.assertEquals(startLoggedPage.getTitleText(), "GitHub");
    }

    @Test
    public void createRepo() {
        StartLoggedPage startPage = logIn();
        RepoCreationPage repoCreationPagePage = startPage.goToRepoCreation();
        RepoPage repoPage = repoCreationPagePage.createRepo(PropertiesContainer.get("test.repositoryName"));
        Assert.assertEquals(repoPage.getTitleText(), "Quick setup");

        deleteRepo(repoPage);
    }

    @Test
    public void updateProfile() {
        StartLoggedPage startPage = logIn();
        EditProfilePage editProfilePage = startPage.goToProfilePage().goToEditProfilePage();
        ProfilePage profilePage = editProfilePage.upDateAvatar(new File("src/main/resources/angryUnicorn.jpg").getAbsolutePath())
                .upDateProfile(
                PropertiesContainer.get("test.profileName"),
                PropertiesContainer.get("test.profileBio"),
                PropertiesContainer.get("test.profileCompany")).goToProfileAfterUpdate();
        List<BaseControl> listOfProfileInformation = profilePage.getProfileInformation();
        List<String> itemsText = new ArrayList<>();
        for(BaseControl info: listOfProfileInformation) {
            itemsText.add(info.getText());
        }
        List<String> propertiesTexts = new ArrayList<>();
        propertiesTexts.add(PropertiesContainer.get("test.profileName"));
        propertiesTexts.add(PropertiesContainer.get("test.profileBio"));
        propertiesTexts.add(PropertiesContainer.get("test.profileCompany"));

        Assert.assertTrue(itemsText.containsAll(propertiesTexts));

        deleteProfileInfo(profilePage);
        }


    private void deleteRepo(RepoPage repoPage) {
        SettingsPage settingsPage = repoPage.goToSettings();
        settingsPage.deleteRepoButton().click();
        settingsPage.deleteRepo(PropertiesContainer.get("test.repositoryName"));
    }

    private void deleteProfileInfo(ProfilePage profilePage) {
        profilePage.goToEditProfilePage().deleteAllInfoFromProfile();
    }
}

//RepoPage - переинициализирует title (29 of code)
//EditProfilePage - upDateProfile - поддержка нескольких вариаций данных
//валидатор картинки