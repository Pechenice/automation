package pages;

import controls.Button;
import controls.Text;
import core.PropertiesContainer;

public class StartLoggedPage extends BasePage {
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
        return new RepoCreationPage();
    }

    public ProfilePage goToProfilePage() {
        button_Profile().click();
        button_EditingProfile().click();
        return new ProfilePage();
    }

    public StartUnloggedPage signOut() {
        button_Profile().click();
        button_SignOut().click();
        return new StartUnloggedPage();
    }

    public SearchResultPage search(String search) {
        text_SearchField().sendKeys(search);
        text_SearchField().pressEnter();
        return new SearchResultPage();
    }
}
