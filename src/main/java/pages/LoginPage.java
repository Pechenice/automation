package pages;

import controls.ButtonControl;
import controls.LinkControl;
import controls.TextControl;

public class LoginPage {
    private TextControl loginField;
    private TextControl passwordField;
    private ButtonControl signInButton;
    private ButtonControl forgotPasswordButton;
    private LinkControl createNewAccount;

    public LoginPage () {
        loginField = TextControl.findTextById("login_field");
        passwordField = TextControl.findTextById("password");
        signInButton = ButtonControl.findButtonByName("commit");
        forgotPasswordButton = ButtonControl.findButtonByClassName("label-link");
        createNewAccount = LinkControl.findLinkByCss("a[href='/join?source=login']");
    }

    public StartPage logIn(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        return new StartPage(true);
    }

}
