package pages;

import controls.ButtonControl;
import controls.TextControl;

public class StartPage {
    private ButtonControl signIn;
    private TextControl title;
    private boolean isUserLogged=false;

    public StartPage() {
        this(false);
    }

    public StartPage(boolean isUserLogged) {
        this.isUserLogged = isUserLogged;
        if (!isUserLogged) {
            signIn = ButtonControl.findButtonByCss("a[href='/login']");
        } else {
            title = TextControl.findTextByCss(".shelf-title");
        }
    }

    public LoginPage goToLoginPage() {
        signIn.click();
        return new LoginPage();
    }

    public String getTitleText() {
        return this.title.getText();
    }
}
