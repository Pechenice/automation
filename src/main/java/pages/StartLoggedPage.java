package pages;

import controls.ButtonControl;
import controls.TextControl;
import core.Driver;
import core.PropertiesContainer;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class StartLoggedPage extends BasePage {
    private ButtonControl getSignOut() {
        return ButtonControl.findButtonByCss("li button[type='submit']");
    }

    private ButtonControl getEditingProfile() {
        return ButtonControl.findButtonByCss("a[href='/" +PropertiesContainer.get("test.login")+ "']");
    }

    private ButtonControl getProfile() {
        return ButtonControl.findButtonByCss("summary[class^='HeaderNavlink']>img[alt='@"+ PropertiesContainer.get("test.login")+"']");
    }

    private ButtonControl getCreateRepo() {
        return ButtonControl.findButtonByCss("a[href='/new'][class^='btn'][data-ga-click^='Hello World']");
    }

    private TextControl getSearchField() {
        return TextControl.findTextByCss("input[class^='form-control']");
    }

    public RepoCreationPage goToRepoCreation() {
        getCreateRepo().click();
        return new RepoCreationPage();
    }

    public ProfilePage goToProfilePage() {
        getProfile().click();
        getEditingProfile().click();
        return new ProfilePage();
    }

    public StartUnloggedPage signOut() {
        getProfile().click();
        getSignOut().click();
        return new StartUnloggedPage();
    }

    public SearchResultPage search(String search) {
        getSearchField().sendKeys(search);
        getSearchField().pressEnter();
        return new SearchResultPage();
    }
}
