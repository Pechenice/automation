package pages;

import controls.Button;
import controls.Text;
import core.PropertiesContainer;
import org.testng.Assert;

public class HomeLoggedPage extends BasePage {
    private Button button_SignOut() {
        return Button.byCss("li button[type='submit']");
    }
    private Button button_EditingProfile() {
        return Button.byCss("a[href='/" +PropertiesContainer.get("test.login")+ "']");
    }
    private Button button_Profile() {
        return Button.byCss("summary[class^='HeaderNavlink']>img[alt='@"+ PropertiesContainer.get("test.login")+"']");
    }
    private Button button_CreateRepo() {
        return Button.byCss("a[href='/new'][class^='btn'][data-ga-click^='Hello World']");
    }
    private Text text_SearchField() {
        return Text.byCss("input[class^='form-control']");
    }

    public RepoCreationPage goToRepoCreation() {
        button_CreateRepo().click();
        RepoCreationPage repoCreationPage = new RepoCreationPage();
        try {
            repoCreationPage.verifyRepoCreation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return repoCreationPage;
    }

    public ProfilePage goToProfilePage() {
        button_Profile().click();
        button_EditingProfile().click();
        ProfilePage profilePage = new ProfilePage();
        try {
            profilePage.verifyProfile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return profilePage;
    }

    public HomeUnloggedPage signOut() {
        button_Profile().click();
        button_SignOut().click();
        HomeUnloggedPage homeUnloggedPage = new HomeUnloggedPage();
        try {
            homeUnloggedPage.verifyHomeUnloggedPage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return homeUnloggedPage;
    }

    public SearchRepoResultPage search(String search) {
        text_SearchField().sendKeys(search);
        text_SearchField().pressEnter();
        SearchRepoResultPage searchRepoResultPage = new SearchRepoResultPage();
        try {
            searchRepoResultPage.verifySearchRepoResults();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.fail();
        }
        return searchRepoResultPage;
    }

    protected void verifyHomeLoggedPage() throws Exception {
        if (!button_CreateRepo().isElementVisible()) {
            throw new Exception("Start a project on Logged Home Page is not visible.");
        }
    }
}
