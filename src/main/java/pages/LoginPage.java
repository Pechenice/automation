package pages;

import controls.ButtonControl;
import controls.LinkControl;
import controls.TextControl;

public class LoginPage extends BasePage {
    private TextControl loginField;
    private TextControl passwordField;
    private ButtonControl signInButton;
    private ButtonControl forgotPasswordButton;
    private LinkControl createNewAccount;

    public LoginPage () {
        loginField = TextControl.findTextByCss("#login_field");
        passwordField = TextControl.findTextByCss("#password");
        signInButton = ButtonControl.findButtonByCss("input[name='commit']");
        forgotPasswordButton = ButtonControl.findButtonByCss(".label-link");
        createNewAccount = LinkControl.findLinkByCss("a[href='/join?source=login']");
    }

    public StartLoggedPage logIn(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        return new StartLoggedPage();
    }

}
