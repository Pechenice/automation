package pages;

import controls.ButtonControl;
import controls.TextControl;
import core.PropertiesContainer;

public class StartPage {
    private ButtonControl signIn;
    private TextControl title;
    private ButtonControl createRepo;
    private boolean isUserLogged=false;
    private ButtonControl profile;
    private ButtonControl editingProfileWithoutInfo;


    public StartPage() {
        this(false);
    }

    public StartPage(boolean isUserLogged) {
        this.isUserLogged = isUserLogged;
        if (!isUserLogged) {
            signIn = ButtonControl.findButtonByCss("a[href='/login']");
        } else {
            title = TextControl.findTextByCss(".shelf-title");
            createRepo = ButtonControl.findButtonByCss("a[href='/new'][class^='btn'][data-ga-click^='Hello World']");
            profile = ButtonControl.findButtonByCss("summary[class^='HeaderNavlink']>img[alt='@"+ PropertiesContainer.get("test.login")+"']");
        }
    }

    public LoginPage goToLoginPage() {
        signIn.click();
        return new LoginPage();
    }

    public RepoCreationPage goToRepoCreation() {
        createRepo.click();
        return new RepoCreationPage();
    }

    public String getTitleText() {
        return this.title.getText();
    }

    public ProfilePage goToProfilePage() {
        profile.click();
        editingProfileWithoutInfo = ButtonControl.findButtonByCss("a[href='/" +PropertiesContainer.get("test.login")+ "']");
        editingProfileWithoutInfo.click();
        return new ProfilePage();
    }
}
